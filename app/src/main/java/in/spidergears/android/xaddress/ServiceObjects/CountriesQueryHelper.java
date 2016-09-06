package in.spidergears.android.xaddress.ServiceObjects;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import in.spidergears.android.xaddress.GreenDAO.Country;
import in.spidergears.android.xaddress.GreenDAO.CountryDao;
import in.spidergears.android.xaddress.GreenDAO.DaoSession;
import in.spidergears.android.xaddress.XAddressApplication;

/**
 * Created by spidergears on 06/09/16.
 */
public class CountriesQueryHelper {
    private String TAG = "CountriesQueryHelper";

    private final static DaoSession daoSession;
    private final static CountryDao countryDao;
    private static Query<Country> countryQuery;

    static {
        Log.d("TAG", "static initializer called");
        daoSession = ((XAddressApplication)XAddressApplication.getAppContext()).getDaoSession();
        countryDao = daoSession.getCountryDao();
    }

    public static List<Country> allCountries(){
        countryQuery = countryDao.queryBuilder().orderAsc(CountryDao.Properties.Name).build();
        Log.d("TAG", "allCountries: " + countryQuery.list().size());
        return  countryQuery.list();
    }

    public void insertCountry(Country country){
        countryDao.insert(country);
        Log.d(TAG, "Inserted new country, Name: " + country.getName());
    }
}