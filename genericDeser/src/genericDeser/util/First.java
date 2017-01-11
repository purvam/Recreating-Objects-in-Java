package genericDeser.util;

import genericDeser.logger.Logger;
import genericDeser.logger.Logger.DebugLevel;

/**
 * First class
 * @author Smurfette
 *
 */
public class First {

	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;
	
	private int noOfIdenticalObj; 

	/**
	 * First constructor
	 * initialize values
	 */
	public First(){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("First constructor called.",db);
		
		
		IntValue =0;
		FloatValue =0;
		ShortValue=0;
		StringValue =null;
		
		setNoOfIdenticalObj(1);
	}

	/**
	 * incrementCount func
	 * to increase number of same data objects
	 */
	public void incrementCount(){
		DebugLevel db = DebugLevel.FIRST;
		Logger.getUniqueInstance();
		Logger.writeMessage("First object "+this.getClass().getName()+" incremented",db);
		

		setNoOfIdenticalObj(getNoOfIdenticalObj() + 1);
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
	 * getStringValue function
	 * @return String
	 */
	public String getStringValue() {
		return StringValue;
	}

	/**
	 * setStringValue function
	 * @param stringValueIn
	 */
	public void setStringValue(String stringValueIn) {
		StringValue = stringValueIn;
	}

	/**
	 * getFloatValue function
	 * @return float
	 */
	public float getFloatValue() {
		return FloatValue;
	}

	/**
	 * setFloatValue function
	 * @param floatValueIn
	 */
	public void setFloatValue(float floatValueIn) {
		FloatValue = floatValueIn;
	}

	/**
	 * getShortValue function
	 * @return Short
	 */
	public short getShortValue() {
		return ShortValue;
	}


	/**
	 * setShortValue function
	 * @param shortValueIn
	 */
	public void setShortValue(short shortValueIn) {
		ShortValue = shortValueIn;
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
	public void setNoOfIdenticalObj(int noOfIdenticalObjIn) {
		this.noOfIdenticalObj = noOfIdenticalObjIn;
	}
	
	/**
	 * hashCode function
	 * @Override
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}

	/**
	 * equals function
	 * @Override
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

}
