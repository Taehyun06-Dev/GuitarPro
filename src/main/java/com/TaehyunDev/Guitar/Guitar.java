package com.TaehyunDev.Guitar;

import com.TaehyunDev.Instrument.Instrument;
import lombok.Getter;

import java.io.Serializable;

public class Guitar extends Instrument implements Serializable {

    @Getter
    private String serialNumber;
    @Getter
    private double price;
    @Getter
    GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        super(serialNumber, price, spec);
    }
}