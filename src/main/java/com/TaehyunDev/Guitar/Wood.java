package com.TaehyunDev.Guitar;

public enum Wood {
    ALDER, BASE, N;

    public String toString() {
        switch (this) {
            case ALDER:
                return "Alder";
            case BASE:
                return "Base";
            default:
                return "Unkown";
        }
    }
}