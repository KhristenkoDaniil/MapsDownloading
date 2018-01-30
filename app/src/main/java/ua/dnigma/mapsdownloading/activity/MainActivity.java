package ua.dnigma.mapsdownloading.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ua.dnigma.mapsdownloading.R;
import ua.dnigma.mapsdownloading.fragments.ContinentFragment;
import ua.dnigma.mapsdownloading.fragments.CountryFragment;
import ua.dnigma.mapsdownloading.fragments.TerritoryFragment;

public class MainActivity extends AppCompatActivity {

    ContinentFragment continentFragment;
    CountryFragment countryFragment;
    TerritoryFragment territoryFragment;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        continentFragment = new ContinentFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.cotainer_id, continentFragment);
        fragmentTransaction.commit();
    }


}
