package oops_practice.gcr_codebase.Class;

public class Ecommerce {

    public static void main(String[] args) {

        System.out.println("Scenario A:");
        ExpressPackage p1 =
                new ExpressPackage("EXP101", 2.5, "Critical");
        p1.printShippingLabel();

        System.out.println("\nScenario B:");
        p1.setWeight(-5);
        System.out.println("Current Weight: " + p1.getWeight());
    }
}

class Package {
    private String trackingId;
    private double weight;

    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;

        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Invalid weight.");
            this.weight = 1.0;
        }
    }

    public String getTrackingId() {
        return trackingId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Error: Weight must be greater than 0.");
        }
    }
}

class ExpressPackage extends Package {
    private String priorityLevel;

    public ExpressPackage(String trackingId,
                          double weight,
                          String priorityLevel) {

        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void printShippingLabel() {
        System.out.println("----- Shipping Label -----");
        System.out.println("Tracking ID : " + getTrackingId());
        System.out.println("Weight      : " + getWeight());
        System.out.println("Priority    : " + getPriorityLevel());
        System.out.println("--------------------------");
    }
}