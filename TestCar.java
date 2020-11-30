/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.util.Scanner;

/**
 *
 * @author ecmil
 */
public class TestCar extends Transportation {

    static String color = "BLUE";

    public static void main(String[] args) {
        System.out.println("There are " + Car.getNumCars() + " cars.");
        Car car1 = new Car();
        System.out.println("There are " + car1.getNumCars() + " cars.");
        car1.printCar();
        System.out.println("--------------------");
        car1.setYear(0);
        car1.setMake("Jeep");
        car1.setModel("Wrangler");
        car1.printCar();
        car1.goForward();
        car1.goReverse();
        car1.stop();
        car1.goLeft();
        System.out.println(car1.color); // will print red
        car1.color = "green";
        setColor(car1, "blue");
        System.out.println(car1.color); // will print blue
        setColor(car1);
        System.out.println(car1.color); // will print BLUE
        car1.goRight();
        Car car2 = new Car(2, "Mazda", "Miata", 1975);
//       Car car2 = new Car();
//        car2.setMake("Mazda");
//        car2.setModel("Miata");
//        car2.setNumPass(2);
//        car2.setYear(1975); 
        int numPass;
        System.out.println("How many passengers? ");
        Scanner input = new Scanner(System.in);
        numPass = input.nextInt();
        car2.setNumPass(numPass);
        System.out.println("There are " + Car.getNumCars() + " cars.");
        car2.printCar();
        Bicycle bike = new Bicycle();
        bike.goForward();
        bike.goLeft();
        bike.goRight();
        bike.goReverse();
        System.out.println("There are " + bike.getNumBicycles() + " bikes.");
        setColor(bike, "Blue");
        System.out.println("The bike color is " + bike.color);
        
        // create new object for the bus class name it bus 
        System.out.println("-------------------- im the bus ");
        Bus bus = new Bus(42, "take to malden", 6, 20, "mercedes", "xi320", 2020);
        bus.start();
        bus.goForward();
        bus.goLeft();
        bus.goReverse();
        bus.stop();
        System.out.println("this the bus make   " + bus.getMake());
        System.out.println("this bus has  " + bus.getNumTires() + "tires");
        
        // create new object name it unicycle and extend from the bicycle 
        System.out.println("-------------------- im the Unicycle ");
        Unicycle unicycle = new Unicycle(2, 50, 16, "le velo", "vel 2020", 2021);
        unicycle.goForward();
        unicycle.goLeft();
        unicycle.goRight();
        unicycle.goReverse();
        unicycle.stop();
        System.out.println("the unicycle" + unicycle.toString() + "the years" + unicycle.getYear() + "the number of the passenger " + unicycle.getNumPassengers());
        
        // create new object name suv and it has to be superclass for car and extends from transpotation class 
        SUV suv = new SUV(8, 6, "VOVO", "325 4BY4", 2020);
        System.out.println("-------------------- im the SUV ");
        suv.goForward();
        suv.goLeft();
        suv.goRight();
        System.out.println("is the car four wheel drive " + suv.carfourbyfour(4 / 4));

    }

    public static void setColor(Transportation t) {
        t.color = color;
    }

    public static void setColor(Transportation t, String color) {
        t.color = color;
    }

}
