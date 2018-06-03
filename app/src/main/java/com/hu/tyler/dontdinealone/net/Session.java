package com.hu.tyler.dontdinealone.net;

import android.app.Activity;

public class Session {

    private static Connection con = new Connection();

    private static Activity activity = null;

    private static boolean isConnected = false;

    private static boolean isMatched = false;

    public static Connection getCon()
    {
        return con;
    }

    public static Activity getActivity()
    {
        return activity;
    }

    public static void setActivity(Activity a)
    {
        activity = a;
    }

    public static boolean isConnected()
    {
        return isConnected;
    }

    public static void setConnected()
    {
        isConnected = true;
    }

    public static boolean isIsMatched() { return isMatched; }

    public static void setIsMatched(boolean matched) { isMatched = matched; }
}