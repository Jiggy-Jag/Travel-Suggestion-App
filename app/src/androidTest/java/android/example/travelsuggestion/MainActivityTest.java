package android.example.travelsuggestion;

import android.widget.Button;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> myActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity myactivity = null;

    @Before
    public void setUp() throws Exception {
        myactivity = myActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        Button btn = myactivity.findViewById(R.id.btn_browse);
        Button btn2 = myactivity.findViewById(R.id.btnLetMeChoose);
        Button btn3 = myactivity.findViewById(R.id.btn_RateUs);

        assertNotNull(btn);
        assertNotNull(btn2);
        assertNotNull(btn3);


    }

    @After
    public void tearDown() throws Exception {
        myactivity = null;
    }
}