package edu.gcit.lab3;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static edu.gcit.lab3.R.id.button_send;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void activityLaunch(){
        onView(withId(R.id.button_send)).perform(click());
        onView(withId(R.id.Receive_msg)).check(matches(isDisplayed()));
        onView(withId(R.id.reply_send)).perform(click());
        onView(withId(R.id.Received_Message)).check(matches(isDisplayed()));
    }
    @Test
    public void textInputOutput() {
    onView(withId(R.id.edit_name)).perform(typeText("This is a text"),closeSoftKeyboard());
    onView(withId(R.id.button_send)).perform(click());
    onView(withId(R.id.textView1)).check(matches(withText("This is a text")));
    }

//   @Test
//   public void textInputOutput(){
//       onView(withId(R.id.edit_name)).perform(typeText("This is a text"));
//       onView(withId(R.id.button_send)).perform(click());
//       onView(withId(R.id.textView1)).check(matches(withText("This is a text")));
//
//   }

//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("edu.gcit.lab3", appContext.getPackageName());
//    }

}