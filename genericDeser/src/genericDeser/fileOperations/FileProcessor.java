package genericDeser.fileOperations;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import genericDeser.logger.Logger;
import genericDeser.logger.Logger.DebugLevel;


/**
 * 
 * @author Smurfette
 *
 */
public class FileProcessor {
	private BufferedReader br;
	
	String inputFileName;
	
	/**
	 * toString method
	 * @return String
	 * to make string of object value
	 */
	public String toString(){
		String str = "FileProcessor class toString Method: Input_filename: " + inputFileName + "\n";
		return str;
	}
	
	/**
	 * FileProcessor constructor
	 * @param inputfileIn
	 */
	public FileProcessor(String inputfileIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called.",db);
		
		inputFileName =inputfileIn;
		try{
			br = new BufferedReader(new FileReader(inputFileName));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}


	
	/**
	 * readNextLine method
	 * @return line
	 * read one line
	 */
	public String readNextLine(){
		String line=null;
		try{
			line=br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
		return line;
	}
	
	
	/**
	 * finalize method
	 * @override Object class finalize method
	 * close bufferedReader object and bufferedWrited object
	 */
	protected void finalize(){
		try{
			if(br!=null)
				br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
		
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}

}

