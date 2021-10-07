package com.pamela.globochat

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

//Class PreferenceFragmentCompat() used to Implement settings in android
class SettingsFragment :PreferenceFragmentCompat() {

override fun onCreatePreferences(savedInstancesStates: Bundle?, rootkey:String){

    setPreferencesFromResource(R.xml.settings, rootkey)
}

}