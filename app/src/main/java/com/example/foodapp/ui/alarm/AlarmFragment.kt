package com.example.foodapp.ui.alarm

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.preference.CheckBoxPreference
import androidx.preference.PreferenceFragmentCompat
import com.example.foodapp.R

class AlarmFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var ALARM: String
    private lateinit var alarmReceiver: AlarmReceiver
    private lateinit var isAlarmOnPreference: CheckBoxPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.alarm)

        init()
        setSummaries()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun init() {
        alarmReceiver = AlarmReceiver()
        ALARM = resources.getString(R.string.key_on)

        isAlarmOnPreference = findPreference<CheckBoxPreference>(ALARM) as CheckBoxPreference
    }

    private fun setSummaries() {
        val sh = preferenceManager.sharedPreferences
        isAlarmOnPreference.isChecked = sh.getBoolean(ALARM, false)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        if (isAlarmOnPreference.isChecked){
            isAlarmOnPreference.isChecked = sharedPreferences.getBoolean(ALARM, false)
            val alamIsOn: String = getString(R.string.alarm_on)
            Toast.makeText(context, alamIsOn, Toast.LENGTH_SHORT).show()
            alarmReceiver.setRepeatingAlarm(requireContext())
        }
        else {
            isAlarmOnPreference.isChecked = sharedPreferences.getBoolean(ALARM, false)
            val alarmIsOff: String = getString(R.string.alarm_off)
            Toast.makeText(context, alarmIsOff, Toast.LENGTH_SHORT).show()
            alarmReceiver.cancelRepeatingAlarm(requireContext())
        }
    }
}