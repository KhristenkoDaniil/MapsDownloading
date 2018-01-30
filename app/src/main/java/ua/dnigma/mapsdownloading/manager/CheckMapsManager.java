package ua.dnigma.mapsdownloading.manager;

import java.util.List;

import ua.dnigma.mapsdownloading.model.Continent;
import ua.dnigma.mapsdownloading.model.Country;
import ua.dnigma.mapsdownloading.model.Territory;

/**
 * Created by Даниил on 30.01.2018.
 */

public class CheckMapsManager {

    public static boolean isMapsInside(Country country, Territory territory, int position) {
        return !country.isInnerRegions()
                || territory.getType().equals("map")
                || country.isInnerRegions() && !country.getTerritoryList().get(position)
                .getType().equals("map");
    }

    public static boolean isCountryHaveTerritory(Country country) {
        return country.isInnerRegions();
    }
}
