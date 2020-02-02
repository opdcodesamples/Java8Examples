package java8.stream.collect.transactionexample;

public class Transaction implements Comparable<Transaction> {
	private double value;
	private String currency;
	private double usdValue;
	
	public Transaction(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	

	public double getUsdValue() {
		return usdValue;
	}

	public void setUsdValue(double usdValue) {
		this.usdValue = usdValue;
	}

	@Override
	public String toString() {
		return "Transaction [value=" + value + ", currency=" + currency + ", usdValue=" + usdValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(usdValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(usdValue) != Double.doubleToLongBits(other.usdValue))
			return false;
		return true;
	}

	@Override
	public int compareTo(Transaction o) {

		return Double.compare(this.usdValue, o.getUsdValue());
	}
	
	

}
