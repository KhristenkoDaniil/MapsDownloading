package ua.dnigma.mapsdownloading.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.dnigma.mapsdownloading.R;
import ua.dnigma.mapsdownloading.adapters.ContinentRecyclerAdapter;
import ua.dnigma.mapsdownloading.adapters.CountryRecyclerAdapter;
import ua.dnigma.mapsdownloading.model.Regions;

/**
 * Created by Даниил on 29.11.2017.
 */

public class ContinentFragment extends Fragment {

    private RecyclerView recyclerView;
    private ContinentRecyclerAdapter continentRecyclerAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_layout, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.maps_recyclerView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        continentRecyclerAdapter = new ContinentRecyclerAdapter(getActivity(),
                new Regions().getContinentList());
        recyclerView.setAdapter(continentRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }


}
