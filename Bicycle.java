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
public class Bicycle extends Transportation {

    private static int numBicycles = 0;
    
    /**
     * default Constructor 
     */
    public Bicycle() {  // constructor (thing that builds or instantiates a car)
        numBicycles++;
    } 
/**
 * Multi-arg constructor
 * @param numPass
 * @param mk
 * @param md
 * @param yr 
 */
    public Bicycle(int numPass, String mk, String md, int yr) { // constructor (thing that builds or instantiates a car)
        super(numPass, mk, md, yr);
        
        numBicycles++;
    }

    
   
    public static int getNumBicycles() {
        return numBicycles;
    }
    
    public void printBicycle() {
        System.out.println("This bicycle is a " + year + " " + make + " " + model +
                " that holds " + numPassengers + " passengers");
    }
    
    public void goReverse() {
       
    }
   
    
    public void start() {
        
            started = true;
      
    }
    public void stop() {
       
        started = true;
    }

}
