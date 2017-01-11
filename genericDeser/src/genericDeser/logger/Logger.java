package genericDeser.logger;

/**
 * 
 * @author Smurfette
 *
 */
public class Logger {

    public static enum DebugLevel {NOTHING, CONSTRUCTOR, FIRST, SECOND, POPULATEOBJECTS};
                                   
    private static DebugLevel debugLevel;
    private static volatile Logger UniqueInstance = null;   
    private Logger() { }  
    
    /**
     * Singleton pattern is implemented
     * @param none
     * @return UniqueInstance
     */
    public static Logger getUniqueInstance() 
    {
       if(UniqueInstance==null) { 
        synchronized (Logger.class) {
            if (UniqueInstance == null) {
                UniqueInstance = new Logger();
            }
        }
       }      
        return UniqueInstance;
    }

    /**
     * method to set debug level
     * @param levelIn
     */
    public static void setDebugValue(int levelIn){
		switch (levelIn){
			case 0: 
				debugLevel = DebugLevel.NOTHING;
				break;
			case 1:
				debugLevel = DebugLevel.CONSTRUCTOR;
				break;
			case 2:
				debugLevel = DebugLevel.FIRST;
				break;
			case 3:
				debugLevel = DebugLevel.SECOND;
				break;
		  	case 4:
		  		debugLevel = DebugLevel.POPULATEOBJECTS;
		  		break;
		  	default:
		  		debugLevel = DebugLevel.NOTHING;
		}
    }

    /**
     * method to seat debug level
     * @param levelIn
     */
    public static void setDebugValue(DebugLevel levelIn){
    	debugLevel = levelIn;
    }

    /**
     * method to print message on stdout for each level
     * @param message
     * @param levelIn
     */
    public static void writeMessage(String message, DebugLevel levelIn){
		if (levelIn == debugLevel)
		    System.out.println(message);
    }

    /**
     * method toString
     */
    public String toString(){
    	return "Debug Level: " + debugLevel;
    }
    
    
}