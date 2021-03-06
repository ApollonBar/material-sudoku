package com.jdamcd.sudoku.settings.user

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.preference.PreferenceManager
import javax.inject.Inject

class Settings @Inject
constructor(private val context: Context) {

    var isTimerEnabled: Boolean
        get() = preferences.getBoolean(SHOW_TIMER_ID, true)
        set(enabled) = preferenceEditor.putBoolean(SHOW_TIMER_ID, enabled).apply()

    var isCheatsEnabled: Boolean
        get() = preferences.getBoolean(SHOW_CHEATS_ID, true)
        set(enabled) = preferenceEditor.putBoolean(SHOW_CHEATS_ID, enabled).apply()

    var isShowErrors: Boolean
        get() = preferences.getBoolean(SHOW_ERRORS_ID, false)
        set(isShowErrors) = preferenceEditor.putBoolean(SHOW_ERRORS_ID, isShowErrors).apply()

    var isHideCompleted: Boolean
        get() = preferences.getBoolean(HIDE_COMPLETED_ID, false)
        set(isHideCompleted) = preferenceEditor.putBoolean(HIDE_COMPLETED_ID, isHideCompleted).apply()

    var isDarkMode: Boolean
        get() = preferences.getBoolean(DARK_MODE_ID, false)
        set(isDarkMode) = preferenceEditor.putBoolean(DARK_MODE_ID, isDarkMode).apply()

    var lastPlayed: Long
        get() = preferences.getLong(LAST_PLAYED_ID, NOT_SET)
        set(lastPlayed) = preferenceEditor.putLong(LAST_PLAYED_ID, lastPlayed).apply()

    var resumePrompt: Boolean
        get() = preferences.getBoolean(RESUME_PROMPT_ID, false)
        set(showResumePrompt) = preferenceEditor.putBoolean(RESUME_PROMPT_ID, showResumePrompt).apply()

    var isRatePromptShown: Boolean
        get() = preferences.getBoolean(RATE_SHOWN_ID, false)
        set(shown) = preferenceEditor.putBoolean(RATE_SHOWN_ID, shown).apply()

    private val preferences: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(context)

    private val preferenceEditor: Editor
        get() = preferences.edit()

    companion object {
        const val NOT_SET = -1L
        const val RATING_THRESHOLD = 3

        private const val SHOW_CHEATS_ID = "settings_cheat"
        private const val SHOW_TIMER_ID = "settings_timer"
        private const val HIDE_COMPLETED_ID = "settings_completed"
        private const val SHOW_ERRORS_ID = "settings_show_errors"
        private const val DARK_MODE_ID = "settings_dark_mode"
        private const val LAST_PLAYED_ID = "last_played"
        private const val RESUME_PROMPT_ID = "resume_prompt"
        private const val RATE_SHOWN_ID = "shown_rate"
    }
}
