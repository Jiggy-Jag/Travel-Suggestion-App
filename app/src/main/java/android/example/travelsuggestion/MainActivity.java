package android.example.travelsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button letMeChoose;
    private Button helpMePick;
    private Button browse;
    private Button Home;
    private Button http;
    private Button RateUs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        helpMePick = (Button) findViewById(R.id.btnHelpMePick);
        letMeChoose = (Button) findViewById(R.id.btnLetMeChoose);
        browse = (Button) findViewById(R.id.btn_browse);
        http = (Button) findViewById(R.id.http);
        RateUs = (Button) findViewById(R.id.btn_RateUs);

    }

    public void openActivityLetMeChoose(View view){
        Intent intent = new Intent(this, map.class);
        startActivity(intent);
    }

    public void openActivityHelpMeChoose(View view){
        Intent intent = new Intent(this, selection.class);
        startActivity(intent);
    }

    public void openActivityLoginScreen(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
    public void openActivityBrowseContinents(View view){
        Intent intent = new Intent(this, browse_continents.class);
        startActivity(intent);
    }

    public void openRatingActivity (View view){
        Intent intent = new Intent(this, Rating_bar.class);
        startActivity(intent);
    }

    public void openHTTPActivity(View view) {
        Intent intent = new Intent(this, http_test.class);
        startActivity(intent);
    }

    public void openActivitySelectedButton(View view) {
        Intent intent = new Intent(this, SelectionButtons.class);
        startActivity(intent);
    }
    public void openActivityFavourite(View view) {
        Intent intent = new Intent(this, Favourite.class);
        startActivity(intent);
    }


}
