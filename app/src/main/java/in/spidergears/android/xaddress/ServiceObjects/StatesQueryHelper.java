package in.spidergears.android.xaddress.ServiceObjects;

import android.util.Log;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import in.spidergears.android.xaddress.GreenDAO.Country;
import in.spidergears.android.xaddress.GreenDAO.CountryDao;
import in.spidergears.android.xaddress.GreenDAO.DaoSession;
import in.spidergears.android.xaddress.GreenDAO.State;
import in.spidergears.android.xaddress.GreenDAO.StateDao;
import in.spidergears.android.xaddress.XAddressApplication;

/**
 * Created by spidergears on 06/09/16.
 */
public class StatesQueryHelper {
    private String TAG = "StatesQueryHelper";

    private final static DaoSession daoSession;
    private final static StateDao stateDao;
    private static Query<State> stateQuery;

    static {
        Log.d("TAG", "static initializer called");
        daoSession = ((XAddressApplication)XAddressApplication.getAppContext()).getDaoSession();
        stateDao = daoSession.getStateDao();
    }

    public static List<State> allStates(){
        stateQuery = stateDao.queryBuilder().orderAsc(StateDao.Properties.Name).build();
        Log.d("TAG", "allCountries: " + stateQuery.list().size());
        return  stateQuery.list();
    }

    public static List<State> statesForCountry(Country country){
        stateQuery = stateDao.queryBuilder()
                .where(StateDao.Properties.Country.eq(country.getName()))
                .orderAsc(StateDao.Properties.Name)
                .build();
        Log.d("TAG", "allCountries: " + stateQuery.list().size());
        return  stateQuery.list();
    }


    public void insertState(State state){
        stateDao.insert(state);
        Log.d(TAG, "Inserted new country, Name: " + state.getName());
    }
}
