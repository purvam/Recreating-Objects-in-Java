package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.PopulateObjects;
import genericDeser.logger.Logger;

public class Driver {
	
	static String INPUT_FILE;
	static int DEBUG_VALUE=0;
	public static void main(String []args){
		
		if(args.length!=2){
			System.out.println("Wrong number of inputs");
			System.exit(0);
		}
		
		if(Integer.parseInt(args[1])>4 || Integer.parseInt(args[1]) <0){
			System.out.println("Incorrect debug value; Use between 0-4");
			System.exit(0);
		}
		
		try{
			DEBUG_VALUE= Integer.parseInt(args[1]);
			INPUT_FILE= args[0];
			
			Logger.getUniqueInstance();
			Logger.setDebugValue(DEBUG_VALUE);
	
			
			FileProcessor fileprocessor = new FileProcessor(INPUT_FILE);
			PopulateObjects populate = new PopulateObjects(fileprocessor);
			populate.deserObjects();
			populate.firstCount();
			populate.secondCount();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
