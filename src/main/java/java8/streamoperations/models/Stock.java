package java8.streamoperations.models;

import java.util.Date;

public class Stock {
	
	private String ticker;
	private double tickerprice;
	private Date tickerDate;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getTickerprice() {
		return tickerprice;
	}
	public void setTickerprice(double tickerprice) {
		this.tickerprice = tickerprice;
	}
	public Date getTickerDate() {
		return tickerDate;
	}
	public void setTickerDate(Date tickerDate) {
		this.tickerDate = tickerDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		result = prime * result + ((tickerDate == null) ? 0 : tickerDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tickerprice);
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
		Stock other = (Stock) obj;
		if (ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!ticker.equals(other.ticker))
			return false;
		if (tickerDate == null) {
			if (other.tickerDate != null)
				return false;
		} else if (!tickerDate.equals(other.tickerDate))
			return false;
		if (Double.doubleToLongBits(tickerprice) != Double.doubleToLongBits(other.tickerprice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stock [ticker=" + ticker + ", tickerprice=" + tickerprice + ", tickerDate=" + tickerDate + "]";
	}
	
	
	
}
