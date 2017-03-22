package com.example.prefthrowaway;

import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.SwitchPreferenceCompat;
import android.widget.Toast;

public class MyPrefFragment extends PreferenceFragment {
    @Override
    public void onCreatePreferences(final Bundle savedInstanceState, final String rootKey) {

        addPreferencesFromResource(R.xml.prefs);

        PreferenceGroup preferenceGroup = (PreferenceGroup) findPreference("pref_cat_1");

        SwitchPreferenceCompat switchPreference = new SwitchPreferenceCompat(getActivity());
        switchPreference.setTitle("new");
        switchPreference.setChecked(true);
        switchPreference.setDefaultValue(true);

        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(final Preference preference, final Object newValue) {

                Toast.makeText(getActivity(), newValue.toString(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        preferenceGroup.addPreference(switchPreference);

    }
}
