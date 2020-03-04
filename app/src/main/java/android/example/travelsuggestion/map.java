package android.example.travelsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback {


    public void LosAngelesInfo(View view){
        Intent intent = new Intent(this,los_angeles_info.class);
        startActivity(intent);
    }


    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_map);
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

        LatLng Singapore = new LatLng(1.354039, 103.867289 );
        map.addMarker(new MarkerOptions().position(Singapore).title("Marker in Singapore"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Singapore));

        LatLng Dubai = new LatLng(25.205643, 55.271498);
        map.addMarker(new MarkerOptions().position(Dubai).title("Marker in Dubai"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Dubai));

        LatLng Havana = new LatLng(23.117582, -82.374214);
        map.addMarker(new MarkerOptions().position(Havana).title("Marker in Havana"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Havana));

        LatLng Kerry = new LatLng(52.143480, -9.624316);
        map.addMarker(new MarkerOptions().position(Kerry).title("Marker in Kerry"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Kerry));

        LatLng Rome = new LatLng(41.903343, 12.494101);
        map.addMarker(new MarkerOptions().position(Rome).title("Marker in Rome"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Rome));

        LatLng Jaipur = new LatLng(26.917596, 75.791231);
        map.addMarker(new MarkerOptions().position(Jaipur).title("Marker in Jaipur"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Jaipur));

        LatLng Rio_de_Janeiro = new LatLng(22.910090, -43.235920);
        map.addMarker(new MarkerOptions().position(Rio_de_Janeiro).title("Marker in Rio de Janeiro"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Rio_de_Janeiro));

        LatLng Petra = new LatLng(30.328603, 35.444351);
        map.addMarker(new MarkerOptions().position(Petra).title("Marker in Petra"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Petra));

        LatLng Dubrovnik = new LatLng(42.652065, 18.092673);
        map.addMarker(new MarkerOptions().position(Dubrovnik).title("Marker in Dubrovnik"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Dubrovnik));

        LatLng Santorini = new LatLng(36.392945,  25.463200);
        map.addMarker(new MarkerOptions().position(Santorini).title("Marker in Santorini"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Santorini));

        LatLng Santiago = new LatLng( -33.503397,  -70.660091);
        map.addMarker(new MarkerOptions().position(Santiago).title("Marker in Santiago"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Santiago));

        LatLng Bora = new LatLng(-16.500307, -151.741644 );
        map.addMarker(new MarkerOptions().position(Bora).title("Marker in Bora"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Bora));

        LatLng Moscow = new LatLng(55.724864, 37.552935);
        map.addMarker(new MarkerOptions().position(Moscow).title("Marker in Moscow"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Moscow));

        LatLng Edinburgh = new LatLng(55.953492, -3.188518);
        map.addMarker(new MarkerOptions().position(Edinburgh).title("Marker in Edinburgh"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Edinburgh));

        LatLng Paro_Valley = new LatLng(27.449254, 89.471571);
        map.addMarker(new MarkerOptions().position(Paro_Valley).title("Marker in Paro Valley"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Paro_Valley));

        LatLng Vancouver = new LatLng(49.272053, -123.128370);
        map.addMarker(new MarkerOptions().position(Vancouver).title("Marker in Vancouver"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Vancouver));

        LatLng Cape_Town = new LatLng(33.937058, 18.427912);
        map.addMarker(new MarkerOptions().position(Cape_Town).title("Marker in Cape Town"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Cape_Town));

        LatLng Waikato  = new LatLng(37.396973,  174.899034);
        map.addMarker(new MarkerOptions().position(Waikato).title("Marker in Waikato"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Waikato));

        LatLng  Amsterdam  = new LatLng(52.342881, 4.910559 );
        map.addMarker(new MarkerOptions().position(Amsterdam ).title("Marker in Amsterdam "));
        map.moveCamera(CameraUpdateFactory.newLatLng(Amsterdam ));

        LatLng Antarctica   = new LatLng(-75.569419,19.955791);
        map.addMarker(new MarkerOptions().position(Antarctica ).title("Marker in Antarctica"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Antarctica));

        LatLng Bali  = new LatLng(-8.331840,   115.100358);
        map.addMarker(new MarkerOptions().position(Bali).title("Marker in Bali"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Bali));

        LatLng  Barbados  = new LatLng(13.173058, -59.544987 );
        map.addMarker(new MarkerOptions().position(Barbados).title("Marker in Barbados"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Barbados));

        LatLng Cairo = new LatLng(30.038367,   31.239788);
        map.addMarker(new MarkerOptions().position(Cairo).title("Marker in Cairo"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Cairo));

        LatLng  Copenhagen  = new LatLng(55.679319,  12.567724);
        map.addMarker(new MarkerOptions().position(Copenhagen ).title("Marker in Copenhagen "));
        map.moveCamera(CameraUpdateFactory.newLatLng(Copenhagen ));

        LatLng  maldives  = new LatLng(-0.287464, 73.418966);
        map.addMarker(new MarkerOptions().position(maldives).title("Marker in Maldives "));
        map.moveCamera(CameraUpdateFactory.newLatLng(maldives ));

        LatLng  Marrakech  = new LatLng(31.648813, -7.986771);
        map.addMarker(new MarkerOptions().position(Marrakech).title("Marker in Marrakech "));
        map.moveCamera(CameraUpdateFactory.newLatLng(Marrakech));

        LatLng  NYC  = new LatLng(40.705478, -73.982470);
        map.addMarker(new MarkerOptions().position(NYC).title("Marker in New York City"));
        map.moveCamera(CameraUpdateFactory.newLatLng(NYC));

        LatLng  Paris  = new LatLng(48.855901,2.356671  );
        map.addMarker(new MarkerOptions().position(Paris).title("Marker in Paris"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Paris));

        LatLng  Tokyo = new LatLng(35.705033, 139.230749);
        map.addMarker(new MarkerOptions().position(Tokyo).title("Marker in Tokyo"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Tokyo));

        LatLng Sydney = new LatLng(-33.896956, 151.192853);
        map.addMarker(new MarkerOptions().position(Sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Sydney));

        LatLng NewOrleans  = new LatLng(30.011340,  -90.006357);
        map.addMarker(new MarkerOptions().position(NewOrleans).title("Marker in New Orleans"));
        map.moveCamera(CameraUpdateFactory.newLatLng(NewOrleans));



























    }
}
