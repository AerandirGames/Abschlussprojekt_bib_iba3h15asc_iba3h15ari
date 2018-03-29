package com.example.kai.appalk;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest
{
    @Rule public final ActivityTestRule<Anmelden> anmelden = new ActivityTestRule<Anmelden>(Anmelden.class);
    @Rule public final ActivityTestRule<Messenger> messenger = new ActivityTestRule<Messenger>(Messenger.class);

    public void shouldBeAbleToLaunchAnmelden ()
    {
        onView(withId(R.id.et_username)).perform(typeText("peter.lustig@gmail.com"));
        onView(withId(R.id.et_passwort)).perform(typeText("Asdf1234"));
        onView(withId(R.id.but_anmelden)).perform(click());
    }
}
