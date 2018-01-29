package ua.dnigma.mapsdownloading.model;

import java.util.List;

/**
 * Created by Даниил on 28.01.2018.
 */

public class Country {

    private String type;
    private String name;
    private String map;
    private boolean innerRegions;
    List<Territory> territoryList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public boolean isInnerRegions() {
        return innerRegions;
    }

    public void setInnerRegions(boolean innerRegions) {
        this.innerRegions = innerRegions;
    }

    public List<Territory> getTerritoryList() {
        return territoryList;
    }

    public void setTerritoryList(List<Territory> territoryList) {
        this.territoryList = territoryList;
    }
}
