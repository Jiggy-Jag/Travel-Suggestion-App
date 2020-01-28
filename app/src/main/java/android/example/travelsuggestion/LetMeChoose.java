package android.example.travelsuggestion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LetMeChoose extends AppCompatActivity {

    public void LosAngelesInfo(View view){
        Intent intent = new Intent(this,los_angeles_info.class);
        startActivity(intent);
    }

    BubblePicker bubblePicker;
    String[] name={
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
        setContentView(R.layout.activity_let_me_choose);

        bubblePicker= (BubblePicker) findViewById(R.id.picker);
        ArrayList<PickerItem> listItems=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            PickerItem item=new PickerItem(name[i],colors[i], Color.WHITE, getDrawable(images[i]));
            listItems.add(item);
        }

        bubblePicker.setItems(listItems);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Toast.makeText(LetMeChoose.this,""+pickerItem.getTitle()+" Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                Toast.makeText(LetMeChoose.this,""+pickerItem.getTitle()+" Deselected",Toast.LENGTH_SHORT).show();
            }

        });

    }
}