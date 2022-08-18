package CabInvoiceGenerators;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class InvoiceGeneratorTest {
	
	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

	@Test
	public void givenDistanceTime_shouldReturnFare() {
		double fare = invoiceGenerator.calculateFare(2.0, 5);
		Assert.assertEquals(25, fare);
	}
	
	@Test
	public void givenDistanceTime_shouldReturn_minimumFare() {
		double fare = invoiceGenerator.calculateFare(0.2, 1);
		Assert.assertEquals(5, fare);

   }
   
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.3, 2) };
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
      }
	
	@Test
	public void givenRideRepository_whenGivenUserID_shouldReturnInvoice() {
		HashMap<Integer, Ride[]> rideRepo = new HashMap<>();
		
		Ride[] ride1 = {new Ride(2.0 , 5) , new Ride(0.2 , 1)};
		Ride[] ride2 = {new Ride(10.0 , 2) , new Ride(5.0 , 1)};
		Ride[] ride3 = {new Ride(7.0 , 3) , new Ride(5.0 , 1)};
		Ride[] ride4 = {new Ride(4.0 , 3) , new Ride(5.0 , 4)};

		rideRepo.put(1, ride1);
		rideRepo.put(2, ride2);
		rideRepo.put(3, ride3);
		rideRepo.put(4, ride4);
		
		int userID = 1;
		
		RideRepository rideRepository = new RideRepository(rideRepo , userID);
		
		InvoiceSummary invoiceSummary = rideRepository.calculateFare();       //actual output
		
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);  //expected output as number of rides(2) in userID=1, total fare as 30.0. 
		
		Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
