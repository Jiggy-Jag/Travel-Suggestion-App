package android.example.travelsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class helpMePick extends FragmentActivity implements OnMapReadyCallback {


    public void LosAngelesInfo(View view){
        Intent intent = new Intent(this,los_angeles_info.class);
        startActivity(intent);
    }


    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me_pick);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        // Add a marker in LA and move the camera
        LatLng LosAngeles = new LatLng(34.053164, -118.252480);
        map.addMarker(new MarkerOptions().position(LosAngeles).title("Marker in Los Angeles"));
        map.moveCamera(CameraUpdateFactory.newLatLng(LosAngeles));

        LatLng London = new LatLng(51.508531, -0.129322);
        map.addMarker(new MarkerOptions().position(London).title("Marker in London"));
        map.moveCamera(CameraUpdateFactory.newLatLng(London));


    }
}
