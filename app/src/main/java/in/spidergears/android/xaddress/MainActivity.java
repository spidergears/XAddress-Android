package in.spidergears.android.xaddress;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private String TAG = "MainAcivity";

    private Marker locationMarker;

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        InputStream is = getResources().openRawResource(R.raw.countries);
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        List myEntries;
        try{
            myEntries  = reader.readAll();
            Log.e(TAG, "onCreate: List Entries: " + myEntries.toArray().toString() );
        }
        catch (IOException ioe){
            Log.e(TAG, "onCreate: IOException reading file");
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap _googleMap) {
        googleMap = _googleMap;
        try {
            googleMap.setMyLocationEnabled(true);
        }
        catch (SecurityException se){
            Toast.makeText(MainActivity.this, "Enable location access first", Toast.LENGTH_SHORT).show();
        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}