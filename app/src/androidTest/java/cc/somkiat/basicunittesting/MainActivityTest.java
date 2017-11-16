package cc.somkiat.basicunittesting;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    ViewInteraction nameText;
    ViewInteraction emailText;
    ViewInteraction saveBtn;
    ViewInteraction reset;

    private void setValue() {
        nameText = onView(allOf(withId(R.id.userNameInput),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),2)));
        emailText = onView(allOf(withId(R.id.emailInput),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),6)));
        saveBtn = onView(allOf(withId(R.id.saveButton), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        7),0)));
    }

    @Test
    public void mainActivityTest() {
        setValue();
        SystemClock.sleep(1000);
        nameText.perform(scrollTo(), replaceText("Hansathon"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        emailText.perform(scrollTo(), replaceText("armhansa@gmail.com"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        emailText.perform(pressImeActionButton());
        saveBtn.perform(scrollTo(), click());
        SystemClock.sleep(5000);

    }

    @Test
    public void mainActivityTest2() {
        setValue();
        SystemClock.sleep(1000);
        nameText.perform(scrollTo(), replaceText("Hansathon"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        emailText.perform(scrollTo(), replaceText("armhansa@"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        emailText.perform(pressImeActionButton());
        saveBtn.perform(scrollTo(), click());
        SystemClock.sleep(5000);

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
