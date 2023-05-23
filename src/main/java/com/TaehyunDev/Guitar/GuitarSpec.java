package com.TaehyunDev.Guitar;

import com.TaehyunDev.Instrument.InstrumentSpec;
import lombok.Getter;

public class GuitarSpec extends InstrumentSpec {
    @Getter
    private Builder builder;
    @Getter
    private String model;
    @Getter
    private Type type;
    @Getter
    private int numStrings;
    @Getter
    private Wood backWood;
    @Getter
    private Wood topWood;


    public GuitarSpec(Builder builder, String model, Type type,
                      int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {
        if ((builder != Builder.N) && (builder != otherSpec.builder)) {
            return false;
        }
        if ((model != null) && (!model.equalsIgnoreCase("n") && (!model.equals("")) &&
                (!model.equalsIgnoreCase(otherSpec.model)))) {
            return false;
        }
        if ((type != Type.N) && (type != otherSpec.type)) {
            return false;
        }
        if ((numStrings != -1) && (numStrings != otherSpec.numStrings)) {
            return false;
        }
        if ((backWood != Wood.N) && (backWood != otherSpec.backWood)) {
            return false;
        }
        if ((topWood != Wood.N) && (topWood != otherSpec.topWood)) {
            return false;
        }
        return true;
    }

}