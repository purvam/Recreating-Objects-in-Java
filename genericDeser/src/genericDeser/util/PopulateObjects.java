package genericDeser.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.logger.Logger;
import genericDeser.logger.Logger.DebugLevel;

/**
 * PopulateObjects Class
 * @author Smurfette
 *
 */
public class PopulateObjects {
	private FileProcessor fp;
	
	private HashMap<Integer,ArrayList<First>> firstDS;
	private HashMap<Integer,ArrayList<Second>> secondDS;
	
	private final HashMap<String, Class<?>> dataType=new HashMap<String, Class<?>>()
	{
		{
			put("int",Integer.TYPE);
			put("float",Float.TYPE);
			put("short",Short.TYPE);
			put("double",Double.TYPE);
			put("boolean",Boolean.TYPE);
			put("String",String.class);
			
		}
	};

	/**
	 * PopulateObjects constructor
	 * @param fpIn
	 */
	public PopulateObjects(FileProcessor fpIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("PopulateObjects constructor called.",db);
		

		
		fp = fpIn;
		
		firstDS = new HashMap<Integer, ArrayList<First>>();
		secondDS = new HashMap<Integer, ArrayList<Second>>();
		
	}
	
	/**
	 * firstCount function
	 * to count total and unique objects
	 */
	public void firstCount(){
		int uniqueCount=0;
		int totalCount=0;
		int tempCount =0;
		
		for(int key : firstDS.keySet()){
			tempCount = firstDS.get(key).size();
			uniqueCount += tempCount;
			
			for(int i=0; i< tempCount; i++){
				totalCount += firstDS.get(key).get(i).getNoOfIdenticalObj();
			}
		}
		 System.out.println("Number of unique First objects: "+uniqueCount);
		 System.out.println("Total Number of First objects: "+totalCount);
	}

	/**
	 * secondCount function
	 * to count total and unique objects
	 */
	public void secondCount(){
		int uniqueCount=0;
		int totalCount=0;
		int tempCount=0;
		
		for(int key : secondDS.keySet()){
			tempCount = secondDS.get(key).size();
			uniqueCount += tempCount;
			
			for(int i=0; i< tempCount; i++){
				totalCount += secondDS.get(key).get(i).getNoOfIdenticalObj();
			}
		}
		 System.out.println("Number of unique Second objects: "+uniqueCount);
		 System.out.println("Total Number of Second objects: "+totalCount);
	}
	
	/**
	 * createObject function
	 * @param obj
	 * @param type
	 * @param var
	 * @param value
	 * to intialize values
	 */
	public void createObject(Object obj, String type, String var, String value){

		Class<? extends Object> objClass = obj.getClass();
	    Class<? extends Object>[] signature = new Class<?>[1];  
	    Object[] params = new Object[1]; 
	    
	    signature[0]=dataType.get(type);
	    
	    if(type.equals("int")){
	    	params[0] = new Integer(Integer.parseInt(value));	
	    }
	    else if(type.equals("short")){
	    	params[0] = new Short(Short.parseShort(value));	
	    }
	    else if(type.equals("float")){
	    	params[0] = new Float(Float.parseFloat(value));	
	    }
	    else if(type.equals("String")){
	    	params[0] = new String(value);	
	    }
	    else if(type.equals("double")){
	    	params[0] = new Double(Double.parseDouble(value));	
	    }
	    else if(type.equals("boolean")){
	    	params[0] = new Boolean(Boolean.parseBoolean(value));	
	    }
	    
		String methodName = "set"+var;
		
		Method meth;
		try {
			meth = objClass.getMethod(methodName, signature);
			meth.invoke(obj, params);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}

	/**
	 * deserObjects function
	 * to read from file and populate data
	 */
	public void deserObjects() {
		String line;
		
		try{
			line= fp.readNextLine();
			
			while(line!=null){
				
				String [] className = null;
				if(line!= null){
					className = line.split(":");
				}
				
				if(className.length==2 && className[0].equals("fqn")){

					/*    make an object of class   */
					Class<?> cls = Class.forName(className[1]);
					Constructor<?> cons = cls.getConstructor(); 
					Object obj = cons.newInstance(); 
					
					line = fp.readNextLine();
					if(line!=null)	className = line.split(":");
					
					while(line!= null && className.length!=2 ){		//if not fqn line
						
						String [] data = line.split(",");
						
						if(data.length==3){
							String [] type = data[0].split("=");

							String [] var = data[1].split("=");
							
							String [] value = data[2].split("=");
							
							createObject(obj, type[1], var[1], value[1]);
						}
						
						//to check on inner while
						line = fp.readNextLine();
						if(line!= null){
							className = line.split(":");
						}
						
					}	//most inner while
					
					String clsnm = obj.getClass().getName();

					int hcode = obj.hashCode();
					
					if(clsnm.contains("First")){
						
						if(firstDS.get(hcode)==null){
							ArrayList<First> tempF = new ArrayList<First>();
							tempF.add((First) obj);
							firstDS.put(hcode, tempF);
							
							DebugLevel db = DebugLevel.POPULATEOBJECTS;
							Logger.getUniqueInstance();
							Logger.writeMessage("First object inserted in data Strcuture",db);
							
						}else{
							ArrayList<First> tempF = firstDS.get(hcode);
							if(tempF.contains(obj)){
								int i= tempF.indexOf(obj);
								tempF.get(i).incrementCount();

								DebugLevel db = DebugLevel.POPULATEOBJECTS;
								Logger.getUniqueInstance();
								Logger.writeMessage("First object count incremented",db);

							}
							else{
								firstDS.get(hcode).add((First) obj);
								
								DebugLevel db = DebugLevel.POPULATEOBJECTS;
								Logger.getUniqueInstance();
								Logger.writeMessage("First object inserted in data Strcuture",db);
							}
						}
						
					}else{
						if(secondDS.get(hcode)==null){
							ArrayList<Second> tempF = new ArrayList<Second>();
							tempF.add((Second) obj);
							secondDS.put(hcode, tempF);
							
							DebugLevel db = DebugLevel.POPULATEOBJECTS;
							Logger.getUniqueInstance();
							Logger.writeMessage("Second object inserted in data Strcuture",db);
						}else{
							ArrayList<Second> tempF = secondDS.get(hcode);
							if(tempF.contains(obj)){
								int i= tempF.indexOf(obj);
								tempF.get(i).incrementCount();
								
								DebugLevel db = DebugLevel.POPULATEOBJECTS;
								Logger.getUniqueInstance();
								Logger.writeMessage("Second object count incremented",db);
							}
							else{
								secondDS.get(hcode).add((Second) obj);
								
								DebugLevel db = DebugLevel.POPULATEOBJECTS;
								Logger.getUniqueInstance();
								Logger.writeMessage("Second object inserted in data Strcuture",db);
							}
						}

					}
					
				}	// if fqn
				
			}	//outer while
		}catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}finally{}
	}
}
