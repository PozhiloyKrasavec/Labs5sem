package com.company;

public class Kancelyaria<Ka>{
    private String type="company";
    private Ka calc;
    Kancelyaria(Ka calc){
        this.calc = calc;
        if (calc.getClass().getTypeName().contains("Integer")) type = "price";
    }
    public String getType() {return type;}
    public Ka getCalculated() {return calc;}
}
