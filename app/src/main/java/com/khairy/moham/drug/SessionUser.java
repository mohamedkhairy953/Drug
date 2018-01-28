package com.khairy.moham.drug;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by moham on 1/24/2018.
 */

public class SessionUser {
    private Context context;
    public String MY_PREFS_NAME = "USER_SESSION";
    public static final int PHARMACY = 1;
    public static final int NORMAL_USER = 2;

    public SessionUser(Context context) {
        this.context = context;
    }


    public void saveUserSession(String key, int type) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("key", key);
        editor.putInt("type", type);
        editor.apply();
    }

    public model retreiveUserSession() {
        String key = "";//"No name defined" is the default value.
        int type = 0; //0 is the default value.

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("key", null);
        if (restoredText != null) {
            key = prefs.getString("key", "No name defined");
            type = prefs.getInt("type", 0);
        }
        return new model(key, type);
    }

    boolean isEmplty() {
        model model = retreiveUserSession();
        return model.type == 0;
    }

    int getUserType() {
        return retreiveUserSession().type;
    }

    class model {
        String name;
        int type;

        public model(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }

}