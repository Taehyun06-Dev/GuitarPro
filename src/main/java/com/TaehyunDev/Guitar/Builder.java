package com.TaehyunDev.Guitar;

public enum Builder {
    FENDER, YAMAHA, SAMSUNG, N;

    public String toString() {
        switch(this) {
            case FENDER:   return "Fender";
            case YAMAHA:  return "Yamaha";
            case SAMSUNG: return "Samsung";
            default:       return "Unkown";
        }
    }
}
