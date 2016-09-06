package in.spidergears.android.xaddress;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.greendao.database.Database;

import in.spidergears.android.xaddress.GreenDAO.DaoMaster;
import in.spidergears.android.xaddress.GreenDAO.DaoSession;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressApplication extends Application {
    private static Context appContext;

    private DaoSession daoSession;
    private final String databaseName = "XAddressDB";

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, databaseName);
        Database XAddressDB = helper.getWritableDb();
        daoSession = new DaoMaster(XAddressDB).newSession();
    }

    public static Context getAppContext(){
        return appContext;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
