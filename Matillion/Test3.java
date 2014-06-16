package com.Massimo.Matillion.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * Test 3
 * For this test, you are provided a .csv file (test_three.csv) containing all the
 * towns in England. You are to produce a method that selects two towns at
 * random from the file, and calculates the amount of time taken to walk between
 * the two. For this task you will use the free Google Distance Matrix API, of
 * which the details are located here:
 * https://developers.google.com/maps/documentation/distancematrix/
 * The output is to be formatted similar to the following:
 * It will take 2 days 6 hours to walk from Stalbridge to Whitchurch.
 * Where Stalbridge and Whitchurch are towns from the file, and the time taken
 * to walk the distance is 2 days and 6 hours.
 */
public class Test3 {

	private static final String fileName = "D:\\test_three.csv";
	private static final String baseUrl = "http://maps.googleapis.com/maps/api/distancematrix/json";
	private static final String queryFormat = "origins=%s&destinations=%s&mode=walking";
	private static final String resultFormat = "It will take %s to walk from %s to %s.";
	
	/**
	 * Reads all the characters in a given file 'filename' and when it
	 * finds a '\n' character, increases the line count.
	 * When it reaches the end of file, returns the count.
	 * 
	 * @param filename      the name of the file to read, path included
	 * @return              the number of lines contained in the file
	 * @throws IOException  throws exception if the file does not exist or 
	 *                       cannot be read
	 */
	private int countLines(String filename) throws IOException {
		
		// this method seems to be faster then using readLine()
		// even if it is only used once in the program, I think it's worth it
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
	/**
	 * Retrieves the address at the 'lineNum' line of the 'fileName' file and
	 * replaces all commas and spaces with '+'.
	 * 
	 * @param fileName      the name of the file to read, path included
	 * @param lineNum       the line number of the address to retrieve
	 * @return              a String, containing the address
	 * @throws IOException  throws exception if the file does not exist or 
	 *                      cannot be read
	 */
	private String getAddress(String fileName, int lineNum) throws IOException{
		
		int count = 0;
		String text = null;
		
		BufferedReader reader =  new BufferedReader(new FileReader(fileName));

		while (count < lineNum && (text = reader.readLine()) != null) {
			count++;
		}
		
		reader.close();
		
		return text.replaceAll("[, ]", "+");
	}
	
	/**
	 * private String askGoogle(String query) throws IOException
	 * 
	 * Performs a query to the Google Distance Matrix web service
	 * (adds the received 'query' to a base URL), returning the 
	 * result as a (multi line) String.
	 * 
	 * @param query         the parameters of the query
	 * @return              a String containing the JSON response
	 * @throws IOException  throws exception about the URL connection 
	 */
	private String askGoogle(String query) throws IOException{

		URL url = new URL(baseUrl+ "?" + query);
		 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine() + "\n"; // "\n" is of me to read it easier
	    scan.close();
	    
	    return str;
	}
	
	/**
	 * public void distanceCalc() throws IOException, JSONException
	 * 
	 * Calculates the time it would take to walk from a random city in England
	 * to another random city. This cities are taken from a .csv file and the
	 * duration is calculated with the Google Distance Matrix web service.
	 * Prints the result in the standard output in this format:
	 * 
	 * "It will take X days, Y hours and Z minutes to walk from City1 to City2."
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public void distanceCalc() throws IOException, JSONException{
		
		int MaxLines = countLines(fileName);
//		System.out.println(MaxLines);
		
		int originLine = 1 + (int)(Math.random() * MaxLines );
		int destLine = 1 + (int)(Math.random() * MaxLines);
//		System.out.println(originLine);
//		System.out.println(destLine);

		String originAddr = getAddress(fileName, originLine);
		String destAddr = getAddress(fileName, destLine);
//		System.out.println(originAddr);
//		System.out.println(destAddr);

		String query = String.format(queryFormat, originAddr, destAddr);
//		System.out.println(askGoogle(query));
		
//	    build a JSON object
	    JSONObject obj = new JSONObject(askGoogle(query));
	    if (! obj.getString("status").equals("OK")){
	    	System.out.println(obj.getString("status"));
	        return; // bad query
	    }
	    
	    JSONObject element = obj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0);
	    if (! element.getString("status").equals("OK")){
	    	System.out.println(element.getString("status"));
	        return; // probably NOT_FOUND exception
	    }
	    
	    String result = element.getJSONObject("duration").getString("text");
//		System.out.println(element.toString());
		
	    System.out.println(String.format(resultFormat, result, originAddr.split("\\+")[0], destAddr.split("\\+")[0]));
	    
	    return;
	}
	
}
