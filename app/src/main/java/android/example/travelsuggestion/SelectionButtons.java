package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import static android.example.travelsuggestion.Favourite.loadFav;


public class SelectionButtons extends AppCompatActivity {

    static ArrayList<String> keywords =new ArrayList<String>();
    Button Shopping, Culture, Sightseeing, Wildlife, Beaches, Scenic_Views, Island,Romantic,Adventurous;

    static TextView selected_shopping, selected_culture, selected_sightseeing, selected_Wildlife, selected_Beaches,selected_Scenic_views,selected_Island,selected_Romantic,selected_Adventures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_buttons);

        loadFav = false;


        //----------Buttons for selection of keywords
        Shopping = findViewById(R.id.Shopping);
        Culture = findViewById(R.id.Culture);
        Sightseeing = findViewById(R.id.Sightseeing);
        Wildlife = findViewById(R.id.Wildlife);
        Beaches = findViewById(R.id.Beaches);
        Scenic_Views = findViewById(R.id.Scenic_Views);
        Island = findViewById(R.id.Island);
        Romantic = findViewById(R.id.Romantic);
        Adventurous = findViewById(R.id.Adventurous);

        //-------TextView for buttons----
        selected_shopping = findViewById(R.id.selected_shopping);
        selected_culture = findViewById(R.id.selected_culture);
        selected_sightseeing = findViewById(R.id.selected_sightseeing);
        selected_Wildlife = findViewById(R.id.selected_Wildlife);
        selected_Beaches = findViewById(R.id.selected_Beaches);
        selected_Scenic_views = findViewById(R.id.selected_Scenic_Views);
        selected_Island = findViewById(R.id.selected_Island);
        selected_Romantic = findViewById(R.id.selected_Romantic);
        selected_Adventures = findViewById(R.id.selected_Adventurous);
    }

    public void onClickShopping(View view) {

        if(keywords.contains("Shopping") ){
            keywords.remove("Shopping");
            Toast.makeText(getApplicationContext(),"Shopping unselected",Toast.LENGTH_SHORT).show();
            selected_shopping.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Shopping");
            Toast.makeText(getApplicationContext(),"Shopping selected" ,Toast.LENGTH_SHORT).show();
            selected_shopping.setBackgroundColor(Color.parseColor("#2ECC71"));
        }


    }

    public void onClickCulture(View view){


        if(keywords.contains("Culture") ){
            keywords.remove("Culture");
            Toast.makeText(getApplicationContext(),"Culture unselected",Toast.LENGTH_SHORT).show();
            selected_culture.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Culture");
            Toast.makeText(getApplicationContext(),"Culture selected" ,Toast.LENGTH_SHORT).show();
            selected_culture.setBackgroundColor(Color.parseColor("#2ECC71"));
        }
    }



    public void onClickSightseeing(View view){

        if(keywords.contains("Sightseeing") ){
            keywords.remove("Sightseeing");
            Toast.makeText(getApplicationContext(),"Sightseeing unselected",Toast.LENGTH_SHORT).show();
            selected_sightseeing.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Sightseeing");
            Toast.makeText(getApplicationContext(),"Sightseeing selected" ,Toast.LENGTH_SHORT).show();
            selected_sightseeing.setBackgroundColor(Color.parseColor("#2ECC71"));
        }
    }
    public void onClickWildlife(View view){

        if(keywords.contains("Wildlife") ){
            keywords.remove("Wildlife");
            Toast.makeText(getApplicationContext(),"Wildlife unselected",Toast.LENGTH_SHORT).show();
            selected_Wildlife.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Wildlife");
            Toast.makeText(getApplicationContext(),"Wildlife selected" ,Toast.LENGTH_SHORT).show();
            selected_Wildlife.setBackgroundColor(Color.parseColor("#2ECC71"));
        }
    }

    public void onClickBeaches(View view){
        if(keywords.contains("Beaches") ){
            keywords.remove("Beaches");
            Toast.makeText(getApplicationContext(),"Beaches unselected",Toast.LENGTH_SHORT).show();
            selected_Beaches.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Beaches");
            Toast.makeText(getApplicationContext(),"Beaches selected" ,Toast.LENGTH_SHORT).show();
            selected_Beaches.setBackgroundColor(Color.parseColor("#2ECC71"));
        }
    }

    public void onClickScenic_Views(View view){

        if(keywords.contains("Scenic Views") ){
            keywords.remove("Scenic Views");
            Toast.makeText(getApplicationContext(),"Scenic Views unselected",Toast.LENGTH_SHORT).show();
            selected_Scenic_views.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Scenic Views");
            Toast.makeText(getApplicationContext(),"Scenic Views selected" ,Toast.LENGTH_SHORT).show();
            selected_Scenic_views.setBackgroundColor(Color.parseColor("#2ECC71"));
        }
    }

    public void onClickIsland(View view){

        if(keywords.contains("Island") ){
            keywords.remove("Island");
            Toast.makeText(getApplicationContext(),"Island unselected",Toast.LENGTH_SHORT).show();
            selected_Island.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Island");
            Toast.makeText(getApplicationContext(),"Island selected" ,Toast.LENGTH_SHORT).show();
            selected_Island.setBackgroundColor(Color.parseColor("#2ECC71"));
        }

    }

    public void onClickRomantic(View view){

        if(keywords.contains("Romantic") ){
            keywords.remove("Romantic");
            Toast.makeText(getApplicationContext(),"Romantic unselected",Toast.LENGTH_SHORT).show();
            selected_Romantic.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Romantic");
            Toast.makeText(getApplicationContext(),"Romantic selected" ,Toast.LENGTH_SHORT).show();
            selected_Romantic.setBackgroundColor(Color.parseColor("#2ECC71"));
        }

    }

    public void onClickAdventurous(View view){
        if(keywords.contains("Adventurous") ){
            keywords.remove("Adventurous");
            Toast.makeText(getApplicationContext(),"Adventurous unselected",Toast.LENGTH_SHORT).show();
            selected_Adventures.setBackgroundColor(Color.parseColor("#CACFD2"));
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Adventurous");
            Toast.makeText(getApplicationContext(),"Adventurous selected" ,Toast.LENGTH_SHORT).show();
            selected_Adventures.setBackgroundColor(Color.parseColor("#2ECC71"));
        }

    }

    public void onClickNext(View view){

        if(keywords.size() == 0 ){
            Toast.makeText(getApplicationContext(),"Select at least one",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), afterselection.class);
            startActivity(intent);
        }


    }

}
