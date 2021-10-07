package com.pamela.globochat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceFragmentCompat


class SettingsFragment :PreferenceFragmentCompat() {

override fun onCreatePrefrences(savedInstancesStates: Bundle?, rootkey:String){

    setPreferencesFromResource(R.xml.settings, rootkey)
}

}