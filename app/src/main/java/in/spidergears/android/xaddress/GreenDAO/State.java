package in.spidergears.android.xaddress.GreenDAO;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by spidergears on 06/09/16.
 */
@Entity
public class State {
//    Entity State = XAddressSchema.addEntity("State");
//    State.addToOne(Country, Country.getPkProperty());
//    State.addStringProperty("Code").primaryKey();
//    State.addStringProperty("Name").notNull();
//    State.addStringProperty("GoogleName");
//    State.addStringProperty("GoogleAdmin");
//    State.addDoubleProperty("Latitude").notNull();
//    State.addDoubleProperty("Longitude").notNull();
//    State.addStringProperty("Bounds").notNull();
//    State.addIntProperty("Combinations").notNull();

    @Property
    public String country;

    @Property
    public String code;

    @Property
    public String name;

    @Property
    public String googleName;

    @Property
    public String googleAdmin;

    @Property
    public double latitude;

    @Property
    public double longitude;

    @Property
    public String bounds;

    @Property
    public int combinations;

    @Generated(hash = 586513515)
    public State(String country, String code, String name, String googleName,
            String googleAdmin, double latitude, double longitude, String bounds,
            int combinations) {
        this.country = country;
        this.code = code;
        this.name = name;
        this.googleName = googleName;
        this.googleAdmin = googleAdmin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bounds = bounds;
        this.combinations = combinations;
    }

    @Generated(hash = 1543113081)
    public State() {
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoogleName() {
        return this.googleName;
    }

    public void setGoogleName(String googleName) {
        this.googleName = googleName;
    }

    public String getGoogleAdmin() {
        return this.googleAdmin;
    }

    public void setGoogleAdmin(String googleAdmin) {
        this.googleAdmin = googleAdmin;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBounds() {
        return this.bounds;
    }

    public void setBounds(String bounds) {
        this.bounds = bounds;
    }

    public int getCombinations() {
        return this.combinations;
    }

    public void setCombinations(int combinations) {
        this.combinations = combinations;
    }

}
