 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threecities;

/**
 *
 * @author Marouan Boussif
 */
 import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeCities {

        public static void main(String[] args) throws Exception {
               //Ask the user to enter 31 integers 
                System.out.println("Enter Boston Temperature for 31 days divided with coma  ");
                
                // use the buuferReader to take input from the user 
                InputStreamReader is = new InputStreamReader (System.in);
                BufferedReader br = new BufferedReader(is);
                String BostonTemp = br.readLine();
                System.out.println("Enter Orly  Temperature for 31 days divided coam  ");
                String OrlyTemp = br.readLine();
                System.out.println("Enter Paris Temperature for 31 days divided with coma ");
                String ParisTemp = br.readLine();
                
                // create 3 arrys to hold the temperature for three cities 
                Double[] Boston = new Double[31];
                Double[] Orly = new Double[31];
                Double[] Paris = new Double[31];
                 // "\\s*,\\s*" is used to parse comma separated input in to a string array. 
                String[] Temperature = BostonTemp.split("\\s*,\\s*");  
                for(int i=0;i<Temperature.length;i++) {
                        Boston[i] = Double.parseDouble(Temperature[i]);
                }
                
                Temperature = OrlyTemp.split("\\s*,\\s*");
                for(int i=0;i<Temperature.length;i++) {
                        Orly[i] = Double.parseDouble(Temperature[i]);
                }
                
                Temperature = ParisTemp.split("\\s*,\\s*");
                for(int i=0;i<Temperature.length;i++) {
                        Paris[i] = Double.parseDouble(Temperature[i]);
                }
                // call the methods Max, for every city 
                int maxTempOfAIndex = MaxTemperature(Boston);
                int maxTempOfBIndex = MaxTemperature(Orly);
                int maxTempOfCIndex = MaxTemperature(Paris);
                
                int minTempOfAIndex = MinTemperature(Boston);
                int minTempOfBIndex = MinTemperature(Orly);
                int minTempOfCIndex = MinTemperature(Paris);
                
                Double avgTempOfA = AverageTemp(Boston);
                Double avgTempOfB = AverageTemp(Orly);
                Double avgTempOfC = AverageTemp(Paris);
                
                int aboveAvgOfA = AboveAverage(Boston, avgTempOfA);
                int aboveAvgOfB = AboveAverage(Orly, avgTempOfB);
                int aboveAvgOfC = AboveAverage(Paris, avgTempOfC);
                
                int belowAvgOfA = BelowAverage(Boston, avgTempOfA);
                int belowAvgOfB = BelowAverage(Boston, avgTempOfB);
                int belowAvgOfC = BelowAverage(Boston, avgTempOfC);
                
                
                System.out.println("Maximum temperature  of Boston = " + Boston[maxTempOfAIndex-1] + " which was on day " + maxTempOfAIndex + ".");
                System.out.println("Minimum temperature of Boston= " + Boston[minTempOfAIndex-1] + " which was on day " + minTempOfAIndex + ".");
                System.out.println("Average tempearture of Boston = " + avgTempOfA + ".");
                System.out.println("In Boston There were " + belowAvgOfA + " days having temp below average and " + aboveAvgOfA + " days having temp above average.");
                
                System.out.println("Maximum temperature  of city Orly = " + Orly[maxTempOfBIndex-1] + " which was on day " + maxTempOfBIndex + ".");
                System.out.println("Minimum temperature of city Orly = " + Orly[minTempOfBIndex-1] + " which was on day " + minTempOfBIndex + ".");
                System.out.println("Average temperature of city Orly = " + avgTempOfB + ".");
                System.out.println("In city B There were " + belowAvgOfB + " days  below average and " + aboveAvgOfB + "  temp above average.");
                
                System.out.println("Maximum temperature of city Paris = " + Paris[maxTempOfCIndex-1] + " which occured on day " + maxTempOfCIndex + ".");
                System.out.println("Minimum temperature  of city Paris = " + Paris[minTempOfCIndex-1] + " which occured on day " + minTempOfCIndex + ".");
                System.out.println("Average temperature of city Paris = " + avgTempOfC + ".");
                System.out.println("In city Paris There were " + belowAvgOfC + " days having temp below average and " + aboveAvgOfC + " days having temp above average.");
                
        }
        
        // calculate maximum temperature day of a city.
        static int MaxTemperature(Double city[]) {
                int size = city.length;
                Double maxTemp = city[0];
                int maxTempIndex = 0;
                for(int i=1;i<size;i++) {
                        if(city[i] > maxTemp) {
                                maxTemp = city[i];
                                maxTempIndex = i;
                        }
                }
                return maxTempIndex+1;
        }
        
        // calculate minimum temperature day of a city.
        static int MinTemperature(Double city[]) {
                int size = city.length;
                Double minTemp = city[0];
                int minTempIndex = 0;
                for(int i=1;i<size;i++) {
                        if(city[i] < minTemp) {
                                minTemp = city[i];
                                minTempIndex = i;
                        }
                }
                return minTempIndex+1;
        }
        
        //  calculate Average temperature of a city.
        static Double AverageTemp(Double city[]) {
                Double averageTemp = 0.0;
                for(int i=0;i<city.length;i++) {
                        averageTemp = averageTemp + city[i];
                }
                
                return (averageTemp/city.length);
        }
        
        // calculate number of days in a city having temperature below average. 
        static int BelowAverage(Double city[], Double AverageTemp) {
                int BelowAverage = 0;
                for(int i=0;i<city.length;i++) {
                        if(city[i] < AverageTemp) {
                                BelowAverage++;
                        }
                }
                return BelowAverage;
        }
        
        // function to calculate number of days in a city having temperature above average. 
        static int AboveAverage(Double city[], Double AverageTemp) {
                int AboveAverage = 0;
                for(int i=0;i<city.length;i++) {
                        if(city[i] > AverageTemp) {
                                AboveAverage++;
                        }
                }
                return AboveAverage;
        }
}