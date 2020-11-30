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
public class Unicycle extends Bicycle {
    
    private static int numUnicycles=0;
    private int brakePads;
    private int rims;

    public Unicycle() {
    }
    public Unicycle(int brakePads, int rims, int numPass, String mk, String md, int yr) {
        super(numPass, mk, md, yr);
        this.brakePads = brakePads;
        this.rims = rims;
    }

    public static int getNumUnicycles() {
        return numUnicycles;
    }

    public static void setNumUnicycles(int numUnicycles) {
        Unicycle.numUnicycles = numUnicycles;
    }

    public int getRims() {
        return rims;
    }

    public void setRims(int rims) {
        this.rims = rims;
    }

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
    public void stop() {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goRight() {
        super.goRight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goLeft() {
        super.goLeft(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goForward() {
        super.goForward(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Unicycle{" + "brakePads=" + brakePads + ", rims=" + rims + '}';
    }

    
   
    }

   
    
    
    
    
