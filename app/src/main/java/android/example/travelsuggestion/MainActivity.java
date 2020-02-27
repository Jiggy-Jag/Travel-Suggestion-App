package android.example.travelsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button letMeChoose;
    private Button helpMePick;
    private Button Home;
    private Button http;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helpMePick = (Button) findViewById(R.id.btnHelpMePick);
        letMeChoose = (Button) findViewById(R.id.btnLetMeChoose);
        http = (Button) findViewById(R.id.http);

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
    public void openBrowseActivity(View view) {
        Intent intent = new Intent(this, browse_screen.class);
        startActivity(intent);

    }
    public void openHTTPActivity(View view) {
        Intent intent = new Intent(this, http_test.class);
        startActivity(intent);

    }

}
