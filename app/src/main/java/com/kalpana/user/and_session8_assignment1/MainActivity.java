package com.kalpana.user.and_session8_assignment1;

import android.annotation.TargetApi;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class MainActivity extends PreferenceActivity {
    private static int prefs=R.xml.preferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        try {
            getClass().getMethod("" +
                    "");
            AddResourceApi11AndGreater();
        } catch (NoSuchMethodException e) { //Api < 11
            AddResourceApiLessThan11();
        }
    }

    @SuppressWarnings("deprecation")
    protected void AddResourceApiLessThan11()
    {
        addPreferencesFromResource(prefs);
    }

    @TargetApi(11)
    protected void AddResourceApi11AndGreater()
    {
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PF()).commit();
    }

    @TargetApi(11)
    public static class PF extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(MainActivity.prefs); //outer class
            // private members seem to be visible for inner class, and
            // making it static made things so much easier
        }
    }
}