package com.TaehyunDev.Instrument;

import com.TaehyunDev.Guitar.Builder;
import com.TaehyunDev.Guitar.Type;
import com.TaehyunDev.Guitar.Wood;
import lombok.Getter;

public abstract class InstrumentSpec {

    @Getter
    private Builder builder;

    @Getter
    private String model;

    @Getter
    private Type type;

    @Getter
    private Wood backWood;

    @Getter
    private Wood topWood;

    public InstrumentSpec(Builder builder, String model, Type type,
                          Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matches(InstrumentSpec otherSpec) {
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
        if ((backWood != Wood.N) && (backWood != otherSpec.backWood)) {
            return false;
        }
        if ((topWood != Wood.N) && (topWood != otherSpec.topWood)) {
            return false;
        }
        return true;
    }
}