package in.spidergears.android.xaddress.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.greenrobot.greendao.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import in.spidergears.android.xaddress.GreenDAO.Country;
import in.spidergears.android.xaddress.GreenDAO.CountryDao;
import in.spidergears.android.xaddress.GreenDAO.DaoSession;
import in.spidergears.android.xaddress.R;
import in.spidergears.android.xaddress.ServiceObjects.CountriesQueryHelper;
import in.spidergears.android.xaddress.XAddressApplication;


public class EncodeXAddress extends AppCompatActivity {
    private String TAG = "MainAcivity";
    private int PLACE_PICKER_REQUEST = 1;
    private Place selectedPlace;
    private TextView thirdPartyAttribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encode_xaddress);

        thirdPartyAttribution = (TextView) findViewById(R.id.thirdPartyAttrs);
        PlaceEncodingTask placeEncodingTask = new PlaceEncodingTask(this);
    }

    public void openPlacePicker(View v){
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        }
        catch (GooglePlayServicesRepairableException |
                GooglePlayServicesNotAvailableException e){
            Log.e(TAG, "openPlacePicker: Exception Occured" + e, null );
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                selectedPlace = PlacePicker.getPlace(this, intent);
                String toastMsg = String.format("Place: %s", selectedPlace.toString());
                Log.e(TAG, "onActivityResult: " + selectedPlace.toString() );
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

                String attributions = (String) selectedPlace.getAttributions();
                if (attributions != null)
                    thirdPartyAttribution.setText(Html.fromHtml(attributions));
            }
        }
    }

    private class PlaceEncodingTask extends AsyncTask<Place, String, String> {//Input, Progress, Return
        private Context context;
        public PlaceEncodingTask (Context _context){
            context = _context;
        }
        protected void onPreExecute() {
            //TODO: Show Progress Dialog box
            Log.e(TAG, "onPreExecute: " );
            super.onPreExecute();
        }

        protected String doInBackground(Place... _place) {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            Place place = _place[0];
            String countryCode;
            String countryState;
            try {
                //TODO: Reverse geocode place
                publishProgress("Getting Address...");
                Address address = geocoder.getFromLocation(place.getLatLng().latitude, place.getLatLng().longitude, 1).get(0);
                //Address address = geocoder.getFromLocation(18.5204, 73.8567, 1).get(0);
                //TODO: Parse Api response to get State and Country
                countryCode = address.getCountryCode();
                countryState = address.getAdminArea();
                publishProgress("Encoding Address...");
                //TODO: Encode with XAddressEncoder
            }
            catch (IOException ioe){
                ioe.printStackTrace();
            }
          return "Encoded Response";
        }

        protected void onProgressUpdate(String... progress) {
            //TODO: Publish progress
        }

        protected void onPostExecute() {
            //TODO: Show Progress Dialog box
        }
    }
}
