package CabInvoiceGenerators;

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

}
