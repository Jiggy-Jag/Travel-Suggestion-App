package android.example.travelsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class browse_screen extends AppCompatActivity {
public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_screen);
    }

    public void Open_los_angeles_info(View view){
        int destination = 1;
        Intent intent = new Intent(this,info_template.class);
        intent.putExtra(EXTRA_TEXT,destination);
        startActivity(intent);

    }

    public void Vancouverinfo(View view) {
        int destination = 2;
        Intent intent = new Intent(this, info_template.class);
        intent.putExtra(EXTRA_TEXT,destination);
        startActivity(intent);
    }

}
