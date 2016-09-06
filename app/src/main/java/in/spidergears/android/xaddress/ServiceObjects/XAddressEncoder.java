package in.spidergears.android.xaddress.ServiceObjects;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import in.spidergears.android.xaddress.R;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressEncoder {
    private String TAG = "XAddressEncoder";

    private Context context;

    public XAddressEncoder(Context _context){
        context = _context;
    };

}
