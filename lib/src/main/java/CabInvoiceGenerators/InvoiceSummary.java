package CabInvoiceGenerators;

public class InvoiceSummary {

	private final int NUM_OF_RIDES;
	private final double TOTAL_FARE;
	private final double AVERAGE_FARE;

	public InvoiceSummary(int nUM_OF_RIDES, double tOTAL_FARE) {
		NUM_OF_RIDES = nUM_OF_RIDES;
		TOTAL_FARE = tOTAL_FARE;
		AVERAGE_FARE = this.TOTAL_FARE / this.NUM_OF_RIDES;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.NUM_OF_RIDES == 0)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceSummary invoiceSummary = (InvoiceSummary) obj;
		return NUM_OF_RIDES == invoiceSummary.NUM_OF_RIDES && Double.compare(invoiceSummary.TOTAL_FARE, TOTAL_FARE) == 0
				&& Double.compare(invoiceSummary.AVERAGE_FARE, AVERAGE_FARE) == 0;
	}
}

