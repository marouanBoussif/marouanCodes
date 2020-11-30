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
public class Transportation {
    protected int numPassengers;  // mNumPassengers
    protected String make;        // mMake
    protected String model;
    protected int year;
    private static int numTransports = 0;
    protected boolean started = false;
    protected String color = "red";
    /**
     * default Constructor 
     */
    public Transportation() {  // constructor (thing that builds or instantiates a car)
        numTransports++;
    }
/**
 * Multi-arg constructor
 * @param numPass
 * @param mk
 * @param md
 * @param yr 
 */
    public Transportation(int numPass, String mk, String md, int yr) { // constructor (thing that builds or instantiates a car)
        setNumPass(numPass);
        setYear(yr);
        make = mk;
        model = md;
        numTransports++;
    }
    public void setNumPass(int numPass) {
        if (numPass < 0) {
            numPass = 0;
        }
        numPassengers = numPass;
    }
    public void setYear(int yr) {
        year = yr;
    }
    public int getNumPassengers() {
        return numPassengers;
    }
    public int getYear(){
        return year;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public void setMake(String mk) {
        make = mk;
    }
    public void setModel (String md) {
        model = md;
    }
    public void goForward() {
        System.out.println("Go forward");
        // update position based on direction and speed
    }
    public void goReverse() {
        System.out.println("Go backward");
    }
    public void goLeft() {
        System.out.println("Go Left");
    }
    public void goRight() {
        System.out.println("Go Right");
    }
    public void start() {
        if (!started) {
            started = true;
            System.out.println("Start");
        }
    }
    public void stop() {
        System.out.println("Stop");
        started = false;
    }
}
