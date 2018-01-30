package ua.dnigma.mapsdownloading.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.dnigma.mapsdownloading.R;
import ua.dnigma.mapsdownloading.manager.CheckMapsManager;
import ua.dnigma.mapsdownloading.model.Continent;
import ua.dnigma.mapsdownloading.model.Country;

/**
 * Created by Даниил on 30.01.2018.
 */

public class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.CountryHolder> {

    private LayoutInflater inflater;
    private List<Continent> continentList = new ArrayList<>();

    public CountryRecyclerAdapter(Context context, List<Continent> continents) {
        this.inflater = LayoutInflater.from(context);
        this.continentList = continents;
    }

    @Override
    public CountryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        CountryHolder holder = new CountryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CountryHolder holder, int position) {
        final Country country = continentList.get(position).getCountryList().get(position);

        holder.country.setText(country.getName());

        if (CheckMapsManager.isMapsInside(country, null, position)) {
            holder.download.setVisibility(View.VISIBLE);
        } else {
            holder.download.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class CountryHolder extends RecyclerView.ViewHolder {

        private ImageView map;
        private TextView country;
        private ImageView download;


        public CountryHolder(View itemView) {
            super(itemView);

            map = itemView.findViewById(R.id.map);
            country = itemView.findViewById(R.id.country);
            download = itemView.findViewById(R.id.download);

        }
    }
}
