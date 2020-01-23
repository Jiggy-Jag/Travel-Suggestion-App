package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class browse_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_screen);
    }
    public void LosAngelesInfo(View view){
        Intent intent = new Intent(this,los_angeles_info.class);
        startActivity(intent);
    }
}
