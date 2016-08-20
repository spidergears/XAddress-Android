package in.spidergears.android.xaddress;

import android.content.Context;
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

    private Context context;

    public XAddressEncoder(Context _context){
        context = _context;
    };

    public String[] getCountryInfo( String countryCode ) {
        InputStream is = context.getResources().openRawResource(R.raw.countries);
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        String[] nextCountryInfo = null;
        try {
            while (( nextCountryInfo = reader.readNext()) != null) {
                if (countryCode.equals(nextCountryInfo[0])) {
                    return nextCountryInfo;
                }
            }
        } catch (IOException ioe) {
            Log.e(TAG, "onCreate: IOException reading file");
        }
        return null;
    }

}
