// 3. Electric Vehicle Charging Network 
// Scenario
// A charging company manages EV charging stations.
// Requirements
// Create a class ChargingStation.
// Static Variables
// totalStations
// electricityRate
// Instance Variables
// stationId
// unitsConsumed
// Constructor
// Initialize stationId using this.
// Increment totalStations.
// Methods
// calculateBill()
// displayStationDetails()
// Additional Rule
// Changing electricity rates should affect all stations immediately.
// Create 5 stations and calculate bills.



package oops_practice.gcr_codebase.Class;

public class ElectricVehicle {
    private String stationId;
    private double unitsConsumed;

    public static int totalStations = 0;
    public static double electricityRate = 5.0;
    public ElectricVehicle(String stationId, double unitsConsumed){
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill(){
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails(){
        System.out.println("Station ID: " + stationId);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Electricity Rate: ₹" + electricityRate);
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("--------------------------------");
    }
}




