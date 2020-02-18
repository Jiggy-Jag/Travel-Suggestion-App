package android.example.travelsuggestion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class selection extends AppCompatActivity {

    BubblePicker bubblePicker;
    static String[] name={
            "Shopping", "Multicultural", "Sightseeing", "Wildlife", "Beaches",
            "Historic Landmarks", "Diverse Food"
    };

    int[] images={
            R.drawable.newyork,
            R.drawable.dubai,
            R.drawable.sydney,
            R.drawable.morocco,
            R.drawable.neworleans,
            R.drawable.france,
            R.drawable.maldives
    };

    int[] colors={
            Color.parseColor("#1A237E"),
            Color.parseColor("#6200EA"),
            Color.parseColor("#004D40"),
            Color.parseColor("#880E4F"),
            Color.parseColor("#B71C1C"),
            Color.parseColor("#5200EA"),
            Color.parseColor("#C04D40"),
    };
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        bubblePicker= (BubblePicker) findViewById(R.id.picker);
        ArrayList<PickerItem> listItems=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            PickerItem item=new PickerItem(name[i],colors[i], Color.WHITE, getDrawable(images[i]));
            listItems.add(item);
        }

        bubblePicker.setItems(listItems);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {

            }

            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                // Intent i = new Intent(getApplicationContext(), info_template.class);
                //  startActivity(i);
                for(int i=0;i<7; i++) {
                    if(pickerItem.getTitle()==name[i]){
                        Intent intent = new Intent(getApplicationContext(), info_template.class);
                        startActivity(intent);
                    }
                }


            }


        });

    }
}