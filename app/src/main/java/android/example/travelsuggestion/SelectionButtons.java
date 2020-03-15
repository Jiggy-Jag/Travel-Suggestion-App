package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

public class SelectionButtons extends AppCompatActivity {

    static ArrayList<String> keywords =new ArrayList<String>();
    Button Shopping, Culture, Sightseeing, Wildlife, Beaches, Scenic_Views, Island,Romantic,Adventurous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_buttons);

        Shopping = findViewById(R.id.Shopping);
        Culture = findViewById(R.id.Culture);
        Sightseeing = findViewById(R.id.Sightseeing);
        Wildlife = findViewById(R.id.Wildlife);
        Beaches = findViewById(R.id.Beaches);
        Scenic_Views = findViewById(R.id.Scenic_Views);
        Island = findViewById(R.id.Island);
        Romantic = findViewById(R.id.Romantic);
        Adventurous = findViewById(R.id.Adventurous);
    }

    public void onClickShopping(View view){

        if(keywords.contains("Shopping") ){
            keywords.remove("Shopping");
            Toast.makeText(getApplicationContext(),"Shopping unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Shopping");
            Toast.makeText(getApplicationContext(),"Shopping selected" ,Toast.LENGTH_SHORT).show();
        }


    }

    public void onClickCulture(View view){


        if(keywords.contains("Culture") ){
            keywords.remove("Culture");
            Toast.makeText(getApplicationContext(),"Culture unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Culture");
            Toast.makeText(getApplicationContext(),"Culture selected" ,Toast.LENGTH_SHORT).show();
        }
    }



    public void onClickSightseeing(View view){

        if(keywords.contains("Sightseeing") ){
            keywords.remove("Sightseeing");
            Toast.makeText(getApplicationContext(),"Sightseeing unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Sightseeing");
            Toast.makeText(getApplicationContext(),"Sightseeing selected" ,Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickWildlife(View view){

        if(keywords.contains("Wildlife") ){
            keywords.remove("Wildlife");
            Toast.makeText(getApplicationContext(),"Wildlife unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Wildlife");
            Toast.makeText(getApplicationContext(),"Wildlife selected" ,Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBeaches(View view){
        if(keywords.contains("Beaches") ){
            keywords.remove("Beaches");
            Toast.makeText(getApplicationContext(),"Beaches unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Beaches");
            Toast.makeText(getApplicationContext(),"Beaches selected" ,Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickScenic_Views(View view){

        if(keywords.contains("Scenic Views") ){
            keywords.remove("Scenic Views");
            Toast.makeText(getApplicationContext(),"Scenic Views unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Scenic Views");
            Toast.makeText(getApplicationContext(),"Scenic Views selected" ,Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickIsland(View view){

        if(keywords.contains("Island") ){
            keywords.remove("Island");
            Toast.makeText(getApplicationContext(),"Island unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Island");
            Toast.makeText(getApplicationContext(),"Island selected" ,Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickRomantic(View view){

        if(keywords.contains("Romantic") ){
            keywords.remove("Romantic");
            Toast.makeText(getApplicationContext(),"Romantic unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Romantic");
            Toast.makeText(getApplicationContext(),"Romantic selected" ,Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickAdventurous(View view){
        if(keywords.contains("Adventurous") ){
            keywords.remove("Adventurous");
            Toast.makeText(getApplicationContext(),"Adventurous unselected",Toast.LENGTH_SHORT).show();
        }
        else if(keywords.size() >= 2){
            Toast.makeText(getApplicationContext(),"Maximum selection: 2 keywords",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            keywords.add("Adventurous");
            Toast.makeText(getApplicationContext(),"Adventurous selected" ,Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickNext(View view){

        Toast.makeText(getApplicationContext(),"Keywords" + keywords ,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), afterselection.class);

        startActivity(intent);
    }

}
