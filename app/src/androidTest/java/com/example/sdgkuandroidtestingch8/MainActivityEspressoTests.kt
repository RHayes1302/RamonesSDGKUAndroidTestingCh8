package com.example.sdgkuandroidtestingch8

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTests {

    // Launches the real MainActivity (uses ActivityScenarioRule internally)
    // and keeps Espresso in sync with the app's Compose screen.
    @get:Rule
    val activityRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun rememberMe_startsUnchecked() {
        onView(withId(R.id.remember_me_checkbox))
            .check(matches(isDisplayed()))
            .check(matches(isNotChecked()))
        onView(withId(R.id.remember_me_text))
            .check(matches(withText("Remember me is unchecked")))
    }

    @Test
    fun clickingRememberMe_updatesTextView() {
        onView(withId(R.id.remember_me_checkbox)).perform(click())

        onView(withId(R.id.remember_me_checkbox)).check(matches(isChecked()))
        onView(withId(R.id.remember_me_text))
            .check(matches(withText("Remember me is checked")))
    }

    @Test
    fun clickingRememberMeTwice_changesTextViewBack() {
        onView(withId(R.id.remember_me_checkbox)).perform(click())
        onView(withId(R.id.remember_me_checkbox)).perform(click())

        onView(withId(R.id.remember_me_text))
            .check(matches(withText("Remember me is unchecked")))
    }
}

