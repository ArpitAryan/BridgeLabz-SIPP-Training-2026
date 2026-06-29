package core_java_practice.gcr_codebase.ExceptionHandling;

public class HospitalBillingSystem {

    public static void main(String[] args) {
        double[] patientBills = { 1200.50, 850.00, 430.75 };

        try {
            double average = calculateAverageBill(new String[] { "1200.50", "850.00", "430.75" });
            System.out.println("Average bill amount: " + average);

            double bill = getPatientBill(patientBills, "1");
            System.out.println("Selected patient bill: " + bill);

            processPayment(bill, 900.00);
            System.out.println("Payment processed successfully.");
        } catch (InsufficientFundsException e) {
            System.out.println("Payment error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Billing system error: " + e.getMessage());
        }
    }
    

    public static double calculateAverageBill(String[] itemCosts) throws Exception {
        try {
            if (itemCosts == null || itemCosts.length == 0) {
                throw new ArithmeticException("No billing items provided");
            }

            double total = 0.0;
            for (String itemCost : itemCosts) {
                total += parseAmount(itemCost);
            }

            return total / itemCosts.length;
        } catch (ArithmeticException e) {
            throw new Exception("Cannot calculate average bill: bill contains zero items.", e);
        }
    }

    public static double getPatientBill(double[] bills, String patientIndexInput) throws Exception {
        try {
            int index = Integer.parseInt(patientIndexInput);
            return bills[index];
        } catch (NumberFormatException e) {
            throw new Exception("Invalid patient index format: '" + patientIndexInput + "'. Please enter a whole number.", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Invalid patient index: '" + patientIndexInput + "'. Valid patient index range is 0 to " + (bills.length - 1) + ".", e);
        }
    }

    public static double parseAmount(String amountText) throws Exception {
        try {
            return Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid amount format: '" + amountText + "'. Please provide a numeric amount.", e);
        }
    }

    public static void processPayment(double billAmount, double paidAmount) throws InsufficientFundsException {
        if (paidAmount < billAmount) {
            throw new InsufficientFundsException(
                    "Insufficient funds: paid " + paidAmount + " but bill amount is " + billAmount + ".");
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
