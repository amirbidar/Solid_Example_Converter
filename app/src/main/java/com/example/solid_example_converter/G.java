package com.example.solid_example_converter;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;

public class G extends Application {
    public static Context Context;
    public static SQLiteDatabase Database;

    private static String getRootDirectory() {
        String result = G.Context.getExternalFilesDir(null).getAbsolutePath();

        if (!result.equals(Environment.MEDIA_MOUNTED))
            result = G.Context.getFilesDir().toString();
        return result;
    }

    public static String getDataBaseDir() {
        return getRootDirectory() + "/Data";

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Context = getApplicationContext();
        new File(getDataBaseDir()).mkdir();
        Database = SQLiteDatabase.openOrCreateDatabase(getDataBaseDir() + "/DB.sqlite", null);
        Database.execSQL("CREATE TABLE IF NOT EXISTS money" +
                "( Id INTEGER ," +
                " Name VARCHAR(50)," +
                " Shortname VARCHAR(50)," +
                " Shortmoney VARCHAR(50) ," +
                " Price VARCHAR(50)," +
                " Picture VARCHAR(200))");



    }
}
