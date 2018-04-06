package com.shohayeb.disuqGuide;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.shohayeb.disuqGuide.SpinnerAdapter.decodeSampledBitmapFromResource;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceFragment extends Fragment {
    private static final String ARG_List = "Place";
    private ArrayList<Place> placesList;
    private ImageView image;
    private TextView costTextView;
    private TextView locationTextView;
    private TextView infoTextView;
    private ImageButton button;
    private android.support.v7.widget.AppCompatSpinner spinner;
    private AnimationDrawable animation;


    public PlaceFragment() {
    }

    public static PlaceFragment newInstance(ArrayList<Place> placeList) {
        PlaceFragment fragment = new PlaceFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_List, placeList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            placesList = (ArrayList<Place>) getArguments().getSerializable(ARG_List);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_place, container, false);
        spinner = rootView.findViewById(R.id.spinner);
        image = rootView.findViewById(R.id.historical_place_image);
        costTextView = rootView.findViewById(R.id.cost);
        locationTextView = rootView.findViewById(R.id.location);
        infoTextView = rootView.findViewById(R.id.information);
        if (placesList != null && placesList.size() > 0) {
            SpinnerAdapter adapter = new SpinnerAdapter(getContext(), placesList.get(0).getSpinnerItemList());
            spinner.setAdapter(adapter);
        }
        button = rootView.findViewById(R.id.imageButton);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                final Place currentPlace = placesList.get(position);
                animation = new AnimationDrawable();
                for (int i : currentPlace.getImageResource()) {
                    Bitmap drawable = decodeSampledBitmapFromResource(getResources(), i, 640, 280);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(drawable);
                    animation.addFrame(bitmapDrawable, 3000);
                }
                animation.setExitFadeDuration(700);
                animation.setEnterFadeDuration(700);
                animation.setOneShot(false);
                image.setScaleType(ImageView.ScaleType.FIT_XY);
                image.setImageDrawable(animation);
                animation.start();
                costTextView.setText(currentPlace.getCost());
                locationTextView.setText(currentPlace.getLocation());
                infoTextView.setText(currentPlace.getInfo());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, getLoc(currentPlace, position));
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                            startActivity(mapIntent);
                        } else {
                            mapIntent.setPackage(null);
                            if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                                startActivity(mapIntent);
                            } else {
                                Toast.makeText(getContext(), "No maps app has been found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private Uri getLoc(Place place, int position) {
        Uri gmmIntentUri;
        if (getResources().getString(place.getMapSearchAddress()).equals("none")) {
            String geo = getResources().getString(place.getGeo());
            String label = getResources().getString(place.getSpinnerItemList().get(position).getName());
            String uriBegin = "geo:" + geo;
            String query = geo + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            return Uri.parse(uriString);
        } else {
            gmmIntentUri = Uri.parse("geo:" + getResources().getString(place.getGeo()) + "?q=" + Uri.encode(getResources().getString(place.getMapSearchAddress())));
        }
        return gmmIntentUri;
    }
}