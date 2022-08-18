package CabInvoiceGenerators;

public class PremiumInvoice {
	private static final double PREMIUM_COST_PER_KILOMETER = 15.0;
	private static final int PREMIUM_COST_PER_MINUTE = 2;
	private static final int PREMIUM_MINIMUM_FARE = 20;
	
	
	public double calculateFare(double distance , int time) {
		double totalFare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_MINUTE;
		return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
	}
	
	
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.DISTANCE , ride.TIME);
		}
		
		return new InvoiceSummary(rides.length, totalFare);
	}

}
