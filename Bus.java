/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

/**
 *
 * @author Admin
 */
public class Bus extends Transportation{
    int numberOfthebus;
    String whereTakeyou;
    int numTires;

    public Bus() {
    }

    public Bus(int numberOfthebus, String whereTakeyou, int numTires) {
        this.numberOfthebus = numberOfthebus;
        this.whereTakeyou = whereTakeyou;
        this.numTires = numTires;
    }

    public Bus(int numberOfthebus, String whereTakeyou, int numTires, int numPass, String mk, String md, int yr) {
        super(numPass, mk, md, yr);
        this.numberOfthebus = numberOfthebus;
        this.whereTakeyou = whereTakeyou;
        this.numTires = numTires;
    

    }

    public int getNumberOfthebus() {
        return numberOfthebus;
    }

    public void setNumberOfthebus(int numberOfthebus) {
        this.numberOfthebus = numberOfthebus;
    }

    public String getWhereTakeyou() {
        return whereTakeyou;
    }

    public void setWhereTakeyou(String whereTakeyou) {
        this.whereTakeyou = whereTakeyou;
    }

    public int getNumTires() {
        return numTires;
    }

    public void setNumTires(int numTires) {
        this.numTires = numTires;
    }
@Override 

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        System.out.println(color+year+model+make);
        return "Bus{" + "numberOfthebus=" + numberOfthebus + ", whereTakeyou=" + whereTakeyou + ", numTires=" + numTires + '}';
    }

    }
    

