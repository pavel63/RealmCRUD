package com.example.android_razrab.realmcrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm. getInstance( this );




       // create();
      //  delete();

      //  update();
      //  read();


    }


    // делаем записи
    void create (){

        realm .beginTransaction();

        MyNotes myNotes = realm . createObject( MyNotes.class );

        myNotes .setName( "Alex" );
        myNotes .setAge( 30 );

        realm .commitTransaction();
    }

    void read (){

        // просто чтение можно делать и без begin и commitTransaction()
        RealmResults <MyNotes> myNotesRealmResults = realm .where( MyNotes.class ) .equalTo( "name" , "Pav" ) .findAll();


        if ( myNotesRealmResults .size() >0 ) {
            String ourValue = myNotesRealmResults.get(0).getName();
            Log.d("NAMEE", ourValue);
        }
    }


    void update (){



        realm.beginTransaction();

        RealmResults<MyNotes> myNotesRealmResults = realm.where(MyNotes.class).equalTo("name", "Alex").findAll();

        if(!myNotesRealmResults.isEmpty()) {

           // for(int i = myNotesRealmResults.size() - 1; i >= 0; i--) {

                myNotesRealmResults.get(0).setAge( 40 );
                myNotesRealmResults .get(0) .setName( "Pav" );
            //}
        }

        realm.commitTransaction();


    }


    void delete (){

        //realm. beginTransaction();
         // В equalTo параметры - первое это имя колонки , второе -значение

        realm.beginTransaction();

        RealmResults<MyNotes> myNotesRealmResults = realm.where(MyNotes.class).equalTo("name", "Alex").findAll();

       // if(!myNotesRealmResults.isEmpty()) {

            //for(int i = myNotesRealmResults.size() - 1; i >= 0; i--) {

              //  myNotesRealmResults.get(i).removeFromRealm();

            //}

         // удалить запись
        myNotesRealmResults .get(0).removeFromRealm();

        // возможно прокатит удаление конкретной записи из столбца
        myNotesRealmResults .get(0) .setName(null);


        //realm.where(MyNotes.class).equalTo("fieldName", "value").findAll().deleteAllFromRealm();

        realm.commitTransaction();

    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm .close();
    }
}


