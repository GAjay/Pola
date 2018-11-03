package com.example.dev.pola;

import android.app.Application;
import android.content.Context;
import com.example.dev.pola.network.RestClient;
import com.example.dev.pola.network.RestServices;


/**
 * @author Ranosys Technologies
 */
public class MyApplication extends Application {

    private RestServices peopleService;

    private static  MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public static MyApplication getApplication(Context context) {
        return application;
    }

    public RestServices getRestServices() {
        if (peopleService == null) {
            peopleService = RestClient.create();
        }

        return peopleService;
    }

}
