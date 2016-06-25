package xyz.phyoekhant.harthapadaythar;

import android.app.Application;
import android.content.Context;

/**
 * Created by Phyoe Khant on 6/23/2016.
 */
public class HarthaPadaytharApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
