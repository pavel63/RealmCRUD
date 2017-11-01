package com.example.android_razrab.realmcrud;

import io.realm.RealmObject;

/**
 * Created by android_razrab on 01/11/2017.
 */

public class MyNotes extends RealmObject {


    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}


