package in.spidergears.android.xaddress;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressEncoder {
    private String TAG = "XAddressEncoder";

    void readCountriesCSV(){
        InputStream is = XAddressApplication.getContext().getResources().openRawResource(R.raw.countries);
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
}
