package com.example.finalrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ContactData extends Application {


    public static ArrayList<Person> personArrayListData;
    @Override
    public void onCreate() {
        super.onCreate();

        personArrayListData = new ArrayList<>();
        personArrayListData.add(new Person("jawad", "1"));
        personArrayListData.add(new Person("jawad2222", "1222222"));
        personArrayListData.add(new Person("jawad33333", "13333"));
        personArrayListData.add(new Person("jawad4444", "144444"));
    }
}
