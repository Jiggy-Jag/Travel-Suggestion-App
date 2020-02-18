package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class info_template extends AppCompatActivity {

    TextView text_summary;
    TextView image;
    RadioButton key_word1 , key_word2 , key_word3, key_word4, key_word5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_template);
        //init layout objects
        text_summary = (TextView) findViewById(R.id.txt_summary);
        image = (TextView) findViewById(R.id.background_image) ;
        key_word1 = (RadioButton) findViewById(R.id.key_word_1);
        //get destination number
        Intent intent = getIntent();
        int destination = intent.getIntExtra(browse_screen.EXTRA_TEXT,0);

        switch (destination){
            case 1:
                update_los_angeles();
                break;
            case 2:
                update_vancouver();
                break;
        }


    }
    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.share:
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "The string you want to share, which can include URLs");
                startActivity(Intent.createChooser(i,"share"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
    public void update_los_angeles(){
        text_summary.setText("los angeles");
        image.setText("LOS ANGELES");
        key_word1.setText("Sunny");


    }
    public void update_vancouver(){
        text_summary.setText("Vancouver");
        image.setText("VANCOUVER");
    }





}
