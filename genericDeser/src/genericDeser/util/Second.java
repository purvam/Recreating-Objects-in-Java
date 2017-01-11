package genericDeser.util;

import genericDeser.logger.Logger;
import genericDeser.logger.Logger.DebugLevel;

/**
 * Second class
 * @author Smurfette
 *
 */
public class Second {

	private int IntValue;
	private double DoubleValue;
	private Boolean BooleanValue;
	
	private int noOfIdenticalObj;

	/**
	 * Second constructor
	 * initialize values
	 */
	public Second(){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Second constructor called.",db);
		

		IntValue=0;
		DoubleValue=0;
		BooleanValue=false;
		
		noOfIdenticalObj=1;
	}
	
	/**
	 * incrementCount func
	 * to increase number of same data objects
	 */
	public void incrementCount(){
		DebugLevel db = DebugLevel.SECOND;
		Logger.getUniqueInstance();
		Logger.writeMessage("Second object "+this.getClass().getName()+" incremented",db);
		

		noOfIdenticalObj++;
	}
	
	/**
	 * getIntValue function
	 * @return int
	 */
	public int getIntValue() {
		return IntValue;
	}

	/**
	 * setIntValue function
	 * @param intValueIn
	 */
	public void setIntValue(int intValueIn) {
		IntValue = intValueIn;
	}

	/**
	 * getDoubleValue function
	 * @return double
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}

	/**
	 * setDoubleValue function
	 * @param doubleValueIn
	 */
	public void setDoubleValue(double doubleValueIn) {
		DoubleValue = doubleValueIn;
	}

	/**
	 * getBooleanValue function
	 * @return Boolean
	 */
	public Boolean getBooleanValue() {
		return BooleanValue;
	}

	/**
	 * setBooleanValue function
	 * @param BooleanValueIn
	 */
	public void setBooleanValue(boolean booleanValueIn) {
		BooleanValue = booleanValueIn;
	}

	/**
	 * getNoOfIdenticalObj function
	 * @return int
	 */
	public int getNoOfIdenticalObj() {
		return noOfIdenticalObj;
	}

	/**
	 * setNoOfIdenticalObj function
	 * @param noOfIdenticalObjIn
	 */
	public void setNoOfIdenticalObj(int noOfIdenticalObj) {
		this.noOfIdenticalObj = noOfIdenticalObj;
	}

	/**
	 * hashCode function
	 * @Override
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BooleanValue == null) ? 0 : BooleanValue.hashCode());
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/**
	 * equals function
	 * @Override
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (BooleanValue == null) {
			if (other.BooleanValue != null)
				return false;
		} else if (!BooleanValue.equals(other.BooleanValue))
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	} 

}
