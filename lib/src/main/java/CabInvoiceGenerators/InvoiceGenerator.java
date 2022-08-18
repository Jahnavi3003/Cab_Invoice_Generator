package CabInvoiceGenerators;

public class InvoiceGenerator {
	
	public static final double COST_PER_KILOMETER = 10.0;
	public static final int COST_PER_MINUTE = 1;
	public static final int MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
		return Math.max(totalFare, MINIMUM_FARE);
 
}

}
