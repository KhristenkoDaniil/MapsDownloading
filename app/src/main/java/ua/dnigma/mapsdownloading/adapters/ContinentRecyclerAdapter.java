package ua.dnigma.mapsdownloading.adapters;

import android.content.ClipData;
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
import ua.dnigma.mapsdownloading.model.Continent;

/**
 * Created by Даниил on 30.01.2018.
 */

public class ContinentRecyclerAdapter extends RecyclerView.Adapter<ContinentRecyclerAdapter.ContinentHolder> {

    private LayoutInflater inflater;
    private List<Continent> continentList = new ArrayList<>();

    public ContinentRecyclerAdapter(Context context, List<Continent> continents) {
        this.inflater = LayoutInflater.from(context);
        this.continentList = continents;
    }

    @Override
    public ContinentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.continent_item, parent, false);
        ContinentHolder holder = new ContinentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContinentHolder holder, int position) {
        final Continent continent = continentList.get(position);

        holder.continent.setText(continent.getName());

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ContinentHolder extends RecyclerView.ViewHolder {

        private ImageView earth;
        private TextView continent;


        public ContinentHolder(View itemView) {
            super(itemView);

            earth = itemView.findViewById(R.id.earth);
            continent = itemView.findViewById(R.id.continent);
        }
    }
}
