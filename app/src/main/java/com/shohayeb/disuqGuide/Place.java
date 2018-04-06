package com.shohayeb.disuqGuide;

import java.io.Serializable;
import java.util.List;

public class Place implements Serializable {
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

    static class SpinnerItem implements Serializable {

        private int imageResource;
        private int name;
        private int shortLocation;

        SpinnerItem(int imageResource, int name, int shortLocation) {
            this.imageResource = imageResource;
            this.name = name;
            this.shortLocation = shortLocation;
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
    }


}
