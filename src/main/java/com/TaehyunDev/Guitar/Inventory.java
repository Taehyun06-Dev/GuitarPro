package com.TaehyunDev.Guitar;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private LinkedList<Guitar> guitars = new LinkedList<Guitar>();

    public void setData(LinkedList<Guitar> tempList) {
        guitars = tempList;
    }

    public LinkedList<Guitar> getGuitarData(){
        return guitars;
    }

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Guitar guitar : guitars) {
            if (searchSpec.matches(guitar.getSpec())){
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}