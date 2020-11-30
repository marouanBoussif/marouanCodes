/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

/**
 *
 * @author Marouan bousssif 
 */
public class SUV extends Transportation  {
   
    
    public double fourbyfour;
    public double size ;
    protected int numPassengers;
    protected String make;        
    protected String model;
    protected int year;

    public SUV() {
    }

    public SUV(double size) {
        this.size = size;
    }

    public SUV(double size, int numPass, String mk, String md, int yr) {
        super(numPass, mk, md, yr);
        this.size = size;
    }
    

    public double getFourbyfour() {
        return fourbyfour;
    }

    public void setFourbyfour(double fourbyfour) {
        this.fourbyfour = fourbyfour;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    public  boolean carfourbyfour (double fourbyfour){
        
        if (fourbyfour==4/4){
          return true;
        }
        else 
            return false;
    }

    @Override
    public String toString() {
        return "SUV{" + "fourbyfour=" + fourbyfour + ", size=" + size + '}';
    }
}