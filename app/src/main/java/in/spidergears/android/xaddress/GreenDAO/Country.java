package in.spidergears.android.xaddress.GreenDAO;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by spidergears on 06/09/16.
 */
@Entity
public class Country {
//    Entity Country = XAddressSchema.addEntity("Country");
//    Country.addStringProperty("Code").primaryKey();
//    Country.addStringProperty("Name").notNull().unique();
//    Country.addDoubleProperty("Latitude").notNull();
//    Country.addDoubleProperty("Longitude").notNull();
//    Country.addStringProperty("Bounds").notNull();
//    Country.addIntProperty("Combinations").notNull();
//    Country.addBooleanProperty("NeedStateboundaries").notNull();

    @Property
    public String code;

    @Property
    public String name;

    @Property
    public double latitude;

    @Property
    public double longitude;

    @Property
    public String bounds;

    @Property
    public int combinations;

    @Property
    public boolean useStateBoundaries;

    @Generated(hash = 1694760761)
    public Country(String code, String name, double latitude, double longitude,
            String bounds, int combinations, boolean useStateBoundaries) {
        this.code = code;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bounds = bounds;
        this.combinations = combinations;
        this.useStateBoundaries = useStateBoundaries;
    }

    @Generated(hash = 668024697)
    public Country() {
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

    public boolean getUseStateBoundaries() {
        return this.useStateBoundaries;
    }

    public void setUseStateBoundaries(boolean useStateBoundaries) {
        this.useStateBoundaries = useStateBoundaries;
    }

}
