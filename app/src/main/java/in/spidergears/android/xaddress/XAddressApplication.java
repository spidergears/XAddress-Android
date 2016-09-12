package in.spidergears.android.xaddress;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.facebook.stetho.Stetho;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import in.spidergears.android.xaddress.GreenDAO.DaoMaster;
import in.spidergears.android.xaddress.GreenDAO.DaoSession;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressApplication extends Application {
    private static Context appContext;

    private DaoSession daoSession;
    private final String databaseName = "xaddressdb";

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        Stetho.initializeWithDefaults(this);
        copyDatabaseFromAssets(databaseName);
        //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, databaseName);
        //Database XAddressDB = helper.getWritableDb();
        //daoSession = new DaoMaster(XAddressDB).newSession();
        SQLiteDatabase xAddressDB = SQLiteDatabase.openDatabase(getDatabasePath(databaseName).getPath(), null, SQLiteDatabase.OPEN_READWRITE);
        DaoMaster daoMaster = new DaoMaster(xAddressDB);
        daoSession = daoMaster.newSession();
    }

    public static Context getAppContext(){
        return appContext;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    private void copyDatabaseFromAssets(String databaseName){
        String outFilePath = getDatabasePath(databaseName).getPath();
        File outFile = new File(outFilePath);
        if (outFile.exists())
                return;
        // Open your local db as the input stream
        try {
            InputStream inStream = getResources().openRawResource(R.raw.xaddressdb);
            outFile.getParentFile().mkdirs();
            outFile.createNewFile();
            OutputStream outStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            outStream.flush();
            outStream.close();
            inStream.close();
            Log.d("XAddressDB", "copyDatabaseFromAssets: Success" );
        }
        catch (IOException ioe){
            Log.e("XAddressDB", "copyDatabaseFromAssets: Error"+ ioe );
            ioe.printStackTrace();
        }
    }

}
