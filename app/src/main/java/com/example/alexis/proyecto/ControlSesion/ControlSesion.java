package com.example.alexis.proyecto.ControlSesion;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alexis on 20/03/2017.
 */

public class ControlSesion {
    private static final String PREFERENCE_NAME = "datos";
    private static final String PREFERENCE_LOGIN = "login";

    public static void logIn(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putBoolean(PREFERENCE_LOGIN,true);
        editor.commit();
    }

    public static void logOut(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putBoolean(PREFERENCE_LOGIN,false);
        editor.commit();
    }

    public static boolean isLogin(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        boolean isLog = myPreference.getBoolean(PREFERENCE_LOGIN,false);
        return isLog;
    }
}
