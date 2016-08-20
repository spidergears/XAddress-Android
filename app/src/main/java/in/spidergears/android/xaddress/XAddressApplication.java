package in.spidergears.android.xaddress;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressApplication extends Application {
    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getContext(){
        return appContext;
    }
}
