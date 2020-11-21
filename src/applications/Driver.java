package applications;

// Import libraries
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import temperatures.Temperature;

/*
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Development Language: Java
 */

/**
 * <p>
 * 		Constructs a {@link Temperature} object to read temperature data from
 * 		a text file, then writes formatted temperature data to a new text file.
 * 		Contains the {@link #main} method and "glues" other classes together.
 * </p>
 * <p>
 * 		Depends on:
 * </p>
 * <ul>
 * 		<li>{@link Temperature}</li>
 * </ul>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" target = "_blank">LinkedIn</a>
 * @version  1.0.1 (01/13/2019)
 * @since  1.0 (04/18/2017)
 */
public class Driver
{ 
// ------------------- Main Method -------------------
	/**
	 * Instantiates and sets up a {@link Temperature}.
	 * 
	 * @param args  Array of command line arguments to be passed
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public static void main(String[] args) throws FileNotFoundException		
	{
		PrintWriter outFile = new PrintWriter("data/outFile.txt");				// Create output file stream
		System.out.println("**************************************************************************");
		System.out.println("***                Writing Temperature Data to a File:                 ***");
		System.out.println("**************************************************************************");
		System.out.println("Writing object data to output file...");
		Temperature monthsTemperatures = new Temperature();						// Construct the Temperature object 
		outFile.println("Monthly Temperatures: | Developer: Brady Lange");
		outFile.println("*****************************************************************************");
		outFile.println(monthsTemperatures);
		double lowestTemperature = monthsTemperatures.indexLowestTemp();		// Retrieve the lowest average temperature 
		outFile.println("*****************************************************************************");
		outFile.println("\nThe lowest temperature of all months is: " + lowestTemperature);
		double highestTemperature = monthsTemperatures.indexHighestTemp();		// Retrieve the highest average temperature
		outFile.println("*****************************************************************************");
		outFile.println("\nThe highest temperature of all months is: " + highestTemperature);
		double averageYrLowTemp = monthsTemperatures.averageLowYearTemp();		// Retrieve the years average low temperatures
		String yearLow = String.format("%.2f" , averageYrLowTemp);
		outFile.println("*****************************************************************************");
		outFile.println("\nThe average low temperature for the year of all the months is: " + yearLow);
		double averageYrHighTemp = monthsTemperatures.averageHighYearTemp();	// Retrieve the years average high temperatures
		String yearHigh = String.format("%.2f", averageYrHighTemp);
		outFile.println("*****************************************************************************");
		outFile.println("\nThe average high temperature for the year of all the months is: " + yearHigh);
		outFile.println("*****************************************************************************");
		System.out.println("Success!");
		System.out.println("**************************************************************************\n");
		outFile.close();														// Close the output file 
	} 
// ------------------- End Main Method -------------------
} // End of class Driver