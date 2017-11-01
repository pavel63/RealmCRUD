package com.example.android_razrab.realmcrud;

import android.app.Application;



/**
 * Created by android_razrab on 01/11/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



     //   Realm.init(this);

      /*  Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

                        */
    }

    }
