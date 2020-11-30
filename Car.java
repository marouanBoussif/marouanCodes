 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

/** 
 *
 * @author ecmil
 */
public class Car extends SUV {

    protected int numPassengers;  // mNumPassengers
    protected String make;        // mMake
    protected String model;
    protected int year;
    protected static int numCars = 0;
    protected boolean started = false;
    public String color = "red";
    
    /**
     * default Constructor 
     */
    public Car() {  // constructor (thing that builds or instantiates a car)
        numCars++;
    }
    
    
/**
 * Multi-arg constructor
 * @param numPass
 * @param mk
 * @param md
 * @param yr 
 */
    public Car(int numPass, String mk, String md, int yr) { // constructor (thing that builds or instantiates a car)
        
        if (year < 1850) // adjust the year if necessary
            year = 1850;
        numCars++;
    }

    
    public void setYear(int yr) {
        if (yr < 1850) 
            yr = 1850;
        year = yr;
    }
    
    public static int getNumCars() {
        return numCars;
    }
    
    public void printCar() {
        System.out.println("This car is a " + year + " " + make + " " + model +
                " that holds " + numPassengers + " passengers");
    }
    
}
