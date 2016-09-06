package in.spidergears.android.xaddress.ServiceObjects;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;
import in.spidergears.android.xaddress.R;

/**
 * Created by spidergears on 20/08/16.
 */
public class XAddressDecoder {
    private String TAG = "XAddressDecoder";

    private Context context;

    public XAddressDecoder(Context _context){
        context = _context;
    };
}
