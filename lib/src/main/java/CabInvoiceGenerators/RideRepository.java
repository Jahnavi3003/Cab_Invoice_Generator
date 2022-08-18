package CabInvoiceGenerators;

import java.util.HashMap;

public class RideRepository {
	private final HashMap<Integer , Ride[]> RIDE_REPOSITORY;
	private final Integer USER_ID;
	
	
	public RideRepository(HashMap<Integer, Ride[]> RIDE_REPOSITORY, Integer USER_ID) {
		this.RIDE_REPOSITORY = RIDE_REPOSITORY;
		this.USER_ID = USER_ID;
	}	

	/** Calculation of total Fare. **/
	public InvoiceSummary calculateFare() {
		if(this.USER_ID == null || this.RIDE_REPOSITORY.get(USER_ID) == null) {
			throw new NullPointerException("Null value is not allowed,");
		}
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] userRideDetails = this.RIDE_REPOSITORY.get(USER_ID);
		
		double totalFare = 0;
		
		for (Ride ride : userRideDetails) {
			totalFare += invoiceGenerator.calculateFare(ride.DISTANCE, ride.TIME);   //Gives total Fare.
		}
		return new InvoiceSummary(userRideDetails.length, totalFare);
	}

}
