package com.shohayeb.disuqGuide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class FragmentAdapter extends FragmentPagerAdapter {
    private static final int FAMOUS_FRAGMENT = 0;
    private static final int PARKS_FRAGMENT = 1;
    private static final int RESTAURANTS_FRAGMENT = 2;
    private static final int HOSPITALS_FRAGMENT = 3;
    private ArrayList<Place> placeList;
    private Context context;

    FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        initiate(position);
        return PlaceFragment.newInstance(placeList);
    }

    private void initiate(int position) {
        placeList = new ArrayList<>();
        ArrayList<Place.SpinnerItem> spinnerPlaceList = new ArrayList<>();
        switch (position) {
            case FAMOUS_FRAGMENT:
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.puto1, R.string.famous_buto_name
                        , R.string.famous_buto_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.desouqy1, R.string.famous_desouki_name
                        , R.string.famous_desouki_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.mary1, R.string.famous_mar_name
                        , R.string.famous_mar_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.bridge1, R.string.famous_bridge_name
                        , R.string.famous_bridge_address));
                placeList.add(new Place(new int[]{R.drawable.puto2, R.drawable.puto1, R.drawable.puto4,
                        R.drawable.puto5, R.drawable.puto6}, R.string.famous_buto_address,
                        R.string.famous_buto_cost, R.string.famous_buto_maps_search, R.string.famous_buto_lat_long,
                        R.string.famous_buto_info, spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.desouqy1, R.drawable.desouqy2, R.drawable.desouqy3,
                        R.drawable.desouqy4, R.drawable.desouqy5}, R.string.famous_desouki_address, R.string.famous_desouki_cost,
                        R.string.famous_desouki_maps_search, R.string.famous_desouki_lat_long,
                        R.string.famous_desouki_info, spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.mary1, R.drawable.mary2, R.drawable.mary3,
                        R.drawable.mary4, R.drawable.mary5}, R.string.famous_mar_address,
                        R.string.famous_mar_cost, R.string.famous_mar_maps_search,
                        R.string.famous_mar_lat_long, R.string.famous_mar_info, spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.bridge1, R.drawable.bridge2, R.drawable.bridge3,
                        R.drawable.bridge6}, R.string.famous_bridge_address,
                        R.string.famous_bridge_cost, R.string.famous_bridge_maps_search,
                        R.string.famous_bridge_lat_long, R.string.famous_bridge_info, spinnerPlaceList));

                break;
            case PARKS_FRAGMENT:
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.om1, R.string.park_umm_alqura_name
                        , R.string.park_umm_alqura_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.family, R.string.park_family_name
                        , R.string.park_family_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.safa1, R.string.park_safa_name
                        , R.string.park_safa_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.nile1, R.string.park_nile_name
                        , R.string.park_nile_address));
                placeList.add(new Place(new int[]{R.drawable.om1, R.drawable.om2, R.drawable.om4,
                        R.drawable.om5, R.drawable.om6, R.drawable.om7, R.drawable.om8, R.drawable.om9,
                        R.drawable.om10, R.drawable.om11, R.drawable.om12, R.drawable.om13, R.drawable.om15},
                        R.string.park_umm_alqura_address, R.string.park_umm_alqura_cost, R.string.park_umm_alqura_maps_search,
                        R.string.park_umm_alqura_lat_long, R.string.park_umm_alqura_info,
                        spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.family, R.drawable.family1, R.drawable.family2,
                        R.drawable.family3, R.drawable.family5}, R.string.park_family_address,
                        R.string.park_family_cost, R.string.park_family_maps_search,
                        R.string.park_family_lat_long, R.string.park_family_info, spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.safa1, R.drawable.safa2,
                        R.drawable.safa3, R.drawable.safa4}, R.string.park_safa_address,
                        R.string.park_safa_cost, R.string.park_safa_maps_search,
                        R.string.park_safa_lat_long, R.string.park_safa_info, spinnerPlaceList));

                placeList.add(new Place(new int[]{R.drawable.nile1, R.drawable.nile2,
                        R.drawable.nile3, R.drawable.nile4, R.drawable.nile5}, R.string.park_nile_address,
                        R.string.park_nile_cost, R.string.park_nile_maps_search,
                        R.string.park_nile_lat_long, R.string.park_nile_info, spinnerPlaceList));
                break;

            case RESTAURANTS_FRAGMENT:
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.demashq1, R.string.restaurant_demashq_name
                        , R.string.restaurant_demashq_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.kfc, R.string.restaurant_kfc_name
                        , R.string.restaurant_kfc_address));
                placeList.add(new Place(new int[]{R.drawable.demashq1, R.drawable.demashq2, R.drawable.demashq3,
                        R.drawable.demashq4, R.drawable.demashq5}, R.string.restaurant_demashq_address,
                        R.string.restaurant_demashq_cost, R.string.restaurant_demashq_maps_search,
                        R.string.restaurant_demashq_lat_long, R.string.restaurant_demashq_info,
                        spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.kfc, R.drawable.kfc2, R.drawable.kfc3}, R.string.restaurant_kfc_address,
                        R.string.restaurant_kfc_cost, R.string.restaurant_kfc_maps_search,
                        R.string.restaurant_kfc_lat_long, R.string.restaurant_kfc_info, spinnerPlaceList));

                break;
            case HOSPITALS_FRAGMENT:
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.h_om9, R.string.hospital_elomoma_name
                        , R.string.hospital_elomoma_address));
                spinnerPlaceList.add(new Place.SpinnerItem(R.drawable.mabara2, R.string.hospital_mabarrah_name
                        , R.string.hospital_mabarrah_address));
                placeList.add(new Place(new int[]{R.drawable.h_om, R.drawable.h_om2, R.drawable.h_om3,
                        R.drawable.h_om5, R.drawable.h_om4, R.drawable.h_om5, R.drawable.h_om8, R.drawable.h_om9,
                        R.drawable.h_om10}, R.string.hospital_elomoma_address, R.string.hospital_elomoma_cost, R.string.hospital_elomoma_maps_search,
                        R.string.hospital_elomoma_lat_long, R.string.hospital_elomoma_info,
                        spinnerPlaceList));
                placeList.add(new Place(new int[]{R.drawable.mabara2, R.drawable.mabara3, R.drawable.mabara4},
                        R.string.hospital_mabarrah_address, R.string.hospital_mabarrah_cost,
                        R.string.hospital_mabarrah_maps_search, R.string.hospital_mabarrah_lat_long,
                        R.string.hospital_mabarrah_info, spinnerPlaceList));
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.famous);
            case 1:
                return context.getString(R.string.parks);
            case 2:
                return context.getString(R.string.restaurants);
            case 3:
                return context.getString(R.string.hospitals);
            default:
                return null;
        }
    }
}
