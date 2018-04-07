package com.shohayeb.disuqGuide;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Place implements Parcelable {
    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
    private int[] imageResource;
    private int location;
    private int cost;
    private int mapSearchAddress;
    private int geo;
    private int info;
    private List<SpinnerItem> spinnerItemList;

    Place(int[] imageResource, int location, int Cost, int mapSearchAddress, int geo, int info, List<SpinnerItem> spinnerItemList) {
        this.imageResource = imageResource;
        this.location = location;
        this.cost = Cost;
        this.mapSearchAddress = mapSearchAddress;
        this.geo = geo;
        this.info = info;
        this.spinnerItemList = spinnerItemList;
    }

    private Place(Parcel in) {
        imageResource = in.createIntArray();
        location = in.readInt();
        cost = in.readInt();
        mapSearchAddress = in.readInt();
        geo = in.readInt();
        info = in.readInt();
    }

    public int getInfo() {
        return info;
    }

    public int getGeo() {
        return geo;
    }

    public List<SpinnerItem> getSpinnerItemList() {
        return spinnerItemList;
    }

    public int[] getImageResource() {
        return imageResource;
    }

    public int getLocation() {
        return location;
    }

    public int getCost() {
        return cost;
    }

    public int getMapSearchAddress() {
        return mapSearchAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(imageResource);
        dest.writeInt(location);
        dest.writeInt(cost);
        dest.writeInt(mapSearchAddress);
        dest.writeInt(geo);
        dest.writeInt(info);
    }

    static class SpinnerItem implements Parcelable {

        public static final Creator<SpinnerItem> CREATOR = new Creator<SpinnerItem>() {
            @Override
            public SpinnerItem createFromParcel(Parcel in) {
                return new SpinnerItem(in);
            }

            @Override
            public SpinnerItem[] newArray(int size) {
                return new SpinnerItem[size];
            }
        };
        private int imageResource;
        private int name;
        private int shortLocation;

        SpinnerItem(int imageResource, int name, int shortLocation) {
            this.imageResource = imageResource;
            this.name = name;
            this.shortLocation = shortLocation;
        }

        SpinnerItem(Parcel in) {
            imageResource = in.readInt();
            name = in.readInt();
            shortLocation = in.readInt();
        }

        public int getImageResource() {
            return imageResource;
        }

        public int getName() {
            return name;
        }

        public int getShortLocation() {
            return shortLocation;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(imageResource);
            dest.writeInt(name);
            dest.writeInt(shortLocation);
        }
    }


}
