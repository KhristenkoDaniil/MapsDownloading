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
import ua.dnigma.mapsdownloading.model.Territory;

/**
 * Created by Даниил on 30.01.2018.
 */

public class TerritoryRecyclerAdapter extends RecyclerView.Adapter<TerritoryRecyclerAdapter.TerritoryHolder> {

    private LayoutInflater inflater;
    private List<Continent> continentList = new ArrayList<>();

    public TerritoryRecyclerAdapter(Context context, List<Continent> continents) {
        this.inflater = LayoutInflater.from(context);
        this.continentList = continents;
    }

    @Override
    public TerritoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.territory_item, parent, false);
        TerritoryHolder holder= new TerritoryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TerritoryHolder holder, int position) {
        final Territory territory = continentList.get(position).getCountryList().get(position)
                .getTerritoryList().get(position);

        holder.territory.setText(territory.getName());

        if (CheckMapsManager.isMapsInside(null, territory, position)) {
            holder.download.setVisibility(View.VISIBLE);
        } else {
            holder.download.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class TerritoryHolder extends RecyclerView.ViewHolder {

        private ImageView map;
        private TextView territory;
        private ImageView download;


        public TerritoryHolder(View itemView) {
            super(itemView);

           map = itemView.findViewById(R.id.map);
           territory = itemView.findViewById(R.id.territory);
           download = itemView.findViewById(R.id.download);

        }
    }
}
