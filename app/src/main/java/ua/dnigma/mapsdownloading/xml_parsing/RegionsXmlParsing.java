package ua.dnigma.mapsdownloading.xml_parsing;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import ua.dnigma.mapsdownloading.R;
import ua.dnigma.mapsdownloading.model.Continent;
import ua.dnigma.mapsdownloading.model.Country;
import ua.dnigma.mapsdownloading.model.Regions;
import ua.dnigma.mapsdownloading.model.Territory;

import static android.content.ContentValues.TAG;

/**
 * Created by Даниил on 28.01.2018.
 */

public class RegionsXmlParsing {
    Regions regions = new Regions();
    List<Continent> continentList = regions.getContinentList();
    Continent continent = new Continent();
    Country country = new Country();


    public void xmlParsingToPojoModel(Context context) {

        try {
            XmlPullParser parser = context.getResources().getXml(R.xml.regions);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("region")) {
                    Continent continent = new Continent();
                    List<Country> countryList = continent.getCountryList();
                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        if (parser.getAttributeName(i).equals("type")) {
                            continent.setType(parser.getAttributeValue(i));
                        }
                        if (parser.getAttributeName(i).equals("name")) {
                            continent.setName(parser.getAttributeValue(i));
                            Log.d(TAG, "xmlParsingToPojoModel: ");
                        }
                        if (parser.getAttributeName(i).equals("inner_download_suffix")) {
                            continent.setInnerRegions(true);
                            Log.d(TAG, "xmlParsingToPojoModel: ");
                            Country country = new Country();
                            List<Territory> territoryList = country.getTerritoryList();
                            for (int j = 0; j < parser.getAttributeCount(); j++) {
                                if (parser.getAttributeName(j).equals("type")) {
                                    country.setType(parser.getAttributeValue(j));
                                }
                                if (parser.getAttributeName(j).equals("name")) {
                                    country.setName(parser.getAttributeValue(j));
                                    Log.d(TAG, "xmlParsingToPojoModel: ");
                                }
                                if (parser.getAttributeName(j).equals("inner_download_suffix")) {
                                    country.setInnerRegions(true);
                                    Log.d(TAG, "xmlParsingToPojoModel: ");
                                    Territory territory = new Territory();

                                    for (int k = 0; k < parser.getAttributeCount(); k++) {
                                        if (parser.getAttributeName(k).equals("type")) {
                                            country.setType(parser.getAttributeValue(k));
                                        }
                                        if (parser.getAttributeName(k).equals("name")) {
                                            country.setName(parser.getAttributeValue(k));
                                            Log.d(TAG, "xmlParsingToPojoModel: ");
                                        }
                                        if (parser.getAttributeName(k).equals("inner_download_suffix")) {
                                            country.setInnerRegions(true);
                                            Log.d(TAG, "xmlParsingToPojoModel: ");
                                        }
                                    }
                                    territoryList.add(territory);
                                    country.setTerritoryList(territoryList);
                                }
                            }
                            countryList.add(country);
                            continent.setCountryList(countryList);
                        }
                    }
                    continentList.add(continent);

                    parser.next();
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
