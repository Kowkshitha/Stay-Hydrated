package om.example.stayhydrated;


import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class IntegrationTests {
    // Define the activity to be tested
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ExampleAssertInDataInHistory() {
        onData(anything()) // Select all elements in a list
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))  // Select the view historyDataText in the element
                .check(matches(withText("[TEMP_TEXT]")));  // Assertion
    }
    @Test
    public void ExampleAssertProgressBar(){
        ProgressBar progressBar = activity.getActivity().findViewById(R.id.progressBar);
        assertThat(progressBar.getProgress(), equalTo(50));
    }
    @Test
    public void ExampleAssertListIsEmptyDroplet(){
        ListView ListView = activity.getActivity().findViewById(R.id.historyListView);
        assertThat(ListView.getCount(), equalTo(0));
    }

    @Test
    public void ExamplequalitytestforDroplet(){
        onView(withId(R.id.dropletImage)).perform(click());
        onData(anything()) // Select all elements in a list
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))  // Select the view historyDataText in the element
                .check(matches(withText("50")));  // Assertion

    }
    @Test
    public void Examplequalitytestforglass(){
        onView(withId(R.id.glassImage)).perform(click());
        onData(anything()) // Select all elements in a list
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))  // Select the view historyDataText in the element
                .check(matches(withText("200")));  // Assertion
    }
    @Test
    public void Examplequalitytestforbottle(){
        onView(withId(R.id.bottleImage)).perform(click());
        onData(anything()) // Select all elements in a list
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))  // Select the view historyDataText in the element
                .check(matches(withText("350 ml")));  // Assertion

    }

    @Test
    public void ExampleDropletImage() {
        onView(withId(R.id.dropletImage)).perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataImage))  // Select the view historyDataText in the element
                .check(matches(withTagValue(Matchers.<Object>equalTo(R.drawable.icons8_water_droplet))));  // Assertion
    }



    @Test
    public void ExampleGlassImage() {
        onView(withId(R.id.glassImage)).perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataImage))  // Select the view historyDataText in the element
                .check(matches(withTagValue(Matchers.<Object>equalTo(R.drawable.icons8_water_glass))));  // Assertion
    }

    @Test
    public void ExampleBottleImage() {
        onView(withId(R.id.bottleImage)).perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataImage))  // Select the view historyDataText in the element
                .check(matches(withTagValue(Matchers.<Object>equalTo(R.drawable.icons8_water_bottle))));  // Assertion
    }

    @Test
    public void ExampleDoubleClickDroplet(){
        onView(withId(R.id.dropletImage)).perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))
                .perform(doubleClick())
                .check(matches(withText(String.valueOf(null))));
    }

    @Test
    public void ExampleDoubleClickglass(){
        onView(withId(R.id.glassImage)).perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))
                .perform(doubleClick())
                .check(matches(withText(String.valueOf(null))));
    }

    @Test
    public void DoubleClick() throws InterruptedException {
        onView(withText(R.id.dropletImage)).perform(click());
        Thread.sleep(1000);
        onData(anything())
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))
                .perform(doubleClick())
                .check(matches(withTagValue(Matchers.<Object>equalTo(R.drawable.icons8_water_droplet))));
    }



}