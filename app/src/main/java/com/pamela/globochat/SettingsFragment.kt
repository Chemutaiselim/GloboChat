package com.pamela.globochat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.*

//Class PreferenceFragmentCompat() used to Implement settings in android
class SettingsFragment :PreferenceFragmentCompat() {

override fun onCreatePreferences(savedInstancesStates: Bundle?, rootkey:String?){

    setPreferencesFromResource(R.xml.settings, rootkey)
    val accSettingsPref = findPreference<Preference>(getString(R.string.key_account_settings))

    accSettingsPref?.setOnPreferenceClickListener {

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        val navController = navHostFragment.navController
        val action = SettingsFragmentDirections.actionSettingsToAccSettings()
        navController.navigate(action)
        true
    }
    
    // Read Preference values in a Fragment
    // Step 1: Get reference to the SharedPreferences (XML File)

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    // Step 2: Get the 'value' using the 'key'

    val autoReplyTime = sharedPreferences.getString(getString(R.string.key_auto_reply_time), "")
    Log.i("SettingsFragment", "Auto Reply Time: $autoReplyTime")

    val autoDownload = sharedPreferences.getBoolean(getString(R.string.key_auto_download), false)
    Log.i("SettingsFragment", "Auto Download: $autoDownload")

    val statusPref = findPreference<EditTextPreference>(getString(R.string.key_status))
    statusPref?.setOnPreferenceChangeListener { preference, newValue ->
        val newStatus = newValue as String
        if (newStatus.contains("bad")) {
            Toast.makeText(context, "Inappropriate Status. Please maintain community guidelines.",
                    Toast.LENGTH_SHORT).show()

            false   // false: reject the new value.
        } else {
            true     // true: accept the new value.
        }
    }

    //update the summary

    val notificationpref =findPreference<SwitchPreferenceCompat>(getString(R.string.key_new_msg_notif))
    notificationpref?.summaryProvider= Preference.SummaryProvider<SwitchPreferenceCompat> { switchPref ->

        if (switchPref?.isChecked!!)
            "Status: ON"
        else
            "Status: OFF"
    }


    }
}