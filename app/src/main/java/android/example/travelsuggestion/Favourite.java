package android.example.travelsuggestion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.example.travelsuggestion.afterselection.Favorite;
import static android.example.travelsuggestion.afterselection.idList;

public class Favourite extends AppCompatActivity {

    static  boolean loadFav = true;
    static int globalIndex;
    String image;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        loadFav = true;

        final LinearLayout lm = (LinearLayout) findViewById(R.id.linear_layout);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);

        if(Favorite.isEmpty()){
            final LinearLayout ll1 = new LinearLayout(this);
            ll1.setOrientation(LinearLayout.VERTICAL);

            // Create TextView
            final TextView na = new TextView(this);
            na.setText("No favorites added");
            na.setTextSize(20);
            na.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            na.setPadding(20,10,20,0);
            ll1.addView(na);
        }
        else{
            //Loop to create TextView for each fav country
            for(int j=0;j< Favorite.size();j++)
            {
                // Create LinearLayout
                final LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.VERTICAL);

                // Create TextView
                final TextView product = new TextView(this);
                product.setText(Favorite.get(j));
                image = Favorite.get(j).replaceAll(" ", "_").toLowerCase();
                Context context = product.getContext();
                int id = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
                product.setTextSize(24);
                product.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                product.setPadding(20,10,20,0);
                ll.addView(product);

                // Create Button
                final Button btn = new Button(this);
                // Give button an ID
                btn.setId(j+1);
                btn.setText("View");
                btn.setPadding(20,10,20,0);

                // Create Button2
                final Button btn2 = new Button(this);
                // Give button an ID
                btn2.setId(j+1);
                btn2.setText("Remove");

                btn2.setPadding(20,10,20,0);


                // set the layoutParams on the button
                btn.setLayoutParams(params);
                btn2.setLayoutParams(params);

                // Create TextView
                final TextView space = new TextView(this);
                space.setBackgroundColor(Color.parseColor("#EFEFEF"));
                space.setHeight(5);
                space.setPadding(20,10,20,0);
                ll.addView(space);


                final int index = j;
                globalIndex = index;
                // Set click listener for button
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), afterselection.class);
                        startActivity(intent);
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        ll.removeView(space);
                        ll.removeView(product);
                        ll.removeView(btn);
                        ll.removeView(btn2);

                        Toast.makeText(getApplicationContext(), Favorite.get(index) + "removed from favorites", Toast.LENGTH_LONG).show();
                        Favorite.remove(index);
                    }
                });

                //Add button to LinearLayout
                ll.addView(btn);
                //Add button to LinearLayout
                ll.addView(btn2);
                //Add button to LinearLayout defined in XML
                lm.addView(ll);
            }

        }



    }
}
