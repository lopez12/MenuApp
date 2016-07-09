package com.example.arturo.menuoption;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Arturo on 09/04/2016.
 */
public class Food implements Parcelable {

    public String name;
    public Integer price;

    /**
     * Standard basic constructor for non-parcel
     * object creation
     */
    public Food() { ; };

    /**
     *
     * Constructor to use when re-constructing object
     * from a parcel
     *
     * @param in a parcel from which to read this object
     */
    public Food(Parcel in) {
        readFromParcel(in);
    }

    /**
     * standard getter
     *
     * @return strValue
     */
    public String getStrValue() {
        return name;
    }

    /**
     * Standard setter
     *
     * @param strValue
     */
    public void setStrValue(String strValue) {
        this.name = strValue;
    }

    /**
     * standard getter
     *
     * @return
     */
    public Integer getIntValue() {
        return price;
    }

    /**
     * Standard setter
     *
     * @param intValue
     */
    public void setIntValue(Integer intValue) {
        this.price = intValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // We just need to write each field into the
        // parcel. When we read from parcel, they
        // will come back in the same order
        dest.writeString(name);
        dest.writeInt(price);
    }

    /**
     *
     * Called from the constructor to create this
     * object from a parcel.
     *
     * @param in parcel from which to re-create object
     */
    private void readFromParcel(Parcel in) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        name = in.readString();
        price = in.readInt();
    }

    /**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     *
     * I just find it easier to use the constructor.
     * It makes sense for the way my brain thinks ;-)
     *
     */
    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Food createFromParcel(Parcel in) {
                    return new Food(in);
                }

                public Food[] newArray(int size) {
                    return new Food[size];
                }
            };

}