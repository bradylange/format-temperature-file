package temperatures;

// Import libraries
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Development Language: Java
 */

/**
 * <p>
 * 		Uses an input text file ({@link #inFile}) to instantiate temperature information
 * 		in a two-dimensional array and then writes 
 * 		the data formatted to a new text file with various
 * 		temperature facts for the year.
 * </p>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" target = "_blank">LinkedIn</a>
 * @version  1.0.1 (01/13/2019)
 * @since  1.0 (04/18/2017)
 */
public class Temperature 
{ 
	// Instance variables
	/**
	 * {@link Temperature}'s for each month - Average High/Low for 12 months.
	 * Row One: High {@link Temperature}, Row Two: Low {@link Temperature}.
	 * Column one to twelve are the months from January
	 * to December.
	 */
	private double[][] temps = new double[2][12]; 		
	/**
	 * Input file to be scraped.
	 */
	private Scanner inFile;			
	/**
	 * Average low {@link Temperature} for the year.
	 */
	private double averageLowYear;
	/**
	 * Average high {@link Temperature} for the year.
	 */
	private double averageHighYear;		
	
// ------------------- Default Constructor -------------------
	/**
	 * Constructs a {@link Temperature} object by reading the text
	 * from an input text file, then formats it and writes it to a new text file.
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public Temperature() throws FileNotFoundException							
	{
		// Instantiate default properties
		inFile = new Scanner(new FileReader("data/inFile.txt"));			// Create stream to text file to read from the file
		for (int row = 0; row < temps.length; row ++)						// Iterate through each row of the file 
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the file 
			{
				temps[row][column] = inFile.nextInt(); 						// Read the files temperature data
			}	
		}
		inFile.close();														// Close the input file
	}
// ------------------- End Default Constructor -------------------

// ------------------- Alternate Constructor -------------------
	/**
	 * Constructs a {@link Temperature} object with the property
	 * {@link #temps}.
	 * 
	 * @param tempObject   Monthly high and low {@link #temps} of the year <br>
	 *                     Row one: High {@link Temperature} <br>
	 *                     Row two: Low {@link Temperature} <br>
	 *                     Columns one to twelve are the months of the year
	 */
	public Temperature(double[][] tempObject)
	{
		// Instantiate properties with parameter values
		for (int row = 0; row < temps.length; row ++)						// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of two-dimensional array
			{
				temps[row][column] = tempObject[row][column];				// Set the passed two-dimensional objects data to the class temperature's data 
			}
		}
	} 
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Copy Constructor -------------------
	/**
	 * Constructs a shallow copy of the {@link Temperature} object.
	 * 
	 * @param obj  {@link Temperature} object to be shallow copied
	 */
	public Temperature(Temperature obj)
	{
		// Instantiate properties with parameter value
		for (int row = 0; row < obj.temps.length; row++)					// Iterate through each row of the two-dimensional array
		{	
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				temps[row][column] = obj.temps[row][column];				// Shallow copy passed objects data to the class temperature's data
			}
		}
	}
// ------------------- End Copy Constructor -------------------

// ------------------- Average High Year Temperature Method -------------------
	/**
	 * Calculates the {@link #averageHighYear} {@link Temperature} for the year.
	 * 
	 * @return  {@link #averageHighYear} {@link Temperature} for the year
	 */
	public double averageHighYearTemp()
	{
		// Local variables
		double averageHighSum = 0; 											// Average high temperature for the year
		int highestRow = 0;													// High temperatures row
		
		for (int column = 0; column < temps[highestRow].length; column++)	// Iterate through each column with the high temperature row
		{
			averageHighSum += temps[highestRow][column];					// Sum the average high temperatures
		}
		averageHighYear = averageHighSum / 12.0;							// Calculate the average for the year
		inFile.close(); 													// Close the input file
		return averageHighYear;												// Return average high temperature for the year 
	} 
// ------------------- End Average High Year Temperature Method -------------------
	
// ------------------- Average Low Year Temperature Method -------------------
	/**
	 * Calculates the {@link #averageLowYear} {@link Temperature} for the year.
	 * 
	 * @return  {@link #averageLowYear} {@link Temperature} for the year
	 */
	public double averageLowYearTemp()
	{
		// Local variables
		double averageLowSum = 0; 											// Average low temperature for the year 
		int lowestRow = 1;													// Low temperatures row 
		
		for (int column = 0; column < temps[lowestRow].length; column++)	// Iterate through each column with the low temperature row
		{
			averageLowSum += temps[lowestRow][column];						// Sum the average low temperatures
		}
		averageLowYear = averageLowSum / 12;								// Calculate the average for the year
		return averageLowYear;												// Return average low temperature for the year
	} 
// ------------------- End Average Low Year Temperature Method -------------------
	
// ------------------- Index Highest Temperature Method -------------------
	/**
	 * Retrieves the index of the highest {@link Temperature} of the year.
	 * 
	 * @return  Index of the highest {@link Temperature} of the year
	 */
	public double indexHighestTemp()
	{
		// Local variables
		double highestTemp = temps[0][0];									// Store highest temperature value
		
		for (int row = 0; row < temps.length; row++)						// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				if (temps[row][column] > highestTemp) 						// Highest temperature 
				{
					highestTemp = temps[row][column];						// Set highest temperature 
				}
			}
		}
		return highestTemp;													// Return the highest temperature 
	}
// ------------------- End Index Highest Temperature Method -------------------

// ------------------- Index Lowest Temperature Method -------------------
	/**
	 * Retrieves the index of the lowest {@link Temperature} of the year.
	 * 
	 * @return  Index of the lowest {@link Temperature} of the year
	 */
	public double indexLowestTemp()
	{
		// Local variables
		double lowestTemp = temps[0][0];									// Store the lowest temperature value 
		
		for (int row = 0; row < temps.length; row++)						// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				if (temps[row][column] < lowestTemp)						// Lowest temperature
				{
					lowestTemp = temps[row][column];						// Set lowest temperature
				}
			}
		}
		return lowestTemp;													// Return the lowest temperature 
	} 
// ------------------- End Index Lowest Temperature Method -------------------
	
// ------------------- Set Temperatures Method -------------------
	/**
	 * Updates the high and low {@link #temps} of the year.
	 * 
	 * @param temps  Monthly high and low {@link #temps} of the year <br>
	 *               Row one: High {@link Temperature} <br>
	 *               Row two: Low {@link Temperature} <br>
	 *               Columns one to twelve are the months of the year
	 */
	public void setTemps(double temps[][])
	{
		for (int row = 0; row < temps.length; row ++)						// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				temps[row][column] = temps[row][column];					// Set temperature values 
			}
		}
	}
// ------------------- End Set Temperatures Method -------------------
	
// ------------------- Get Temperatures Method -------------------
	/**
	 * Retrieves the collection of monthly {@link #temps}.
	 * 
	 * @return  Collection of monthly {@link #temps}
	 */
	public double[][] getTemps()
	{
		// Local variables
		double[][] temp = new double[temps.length][0];						// Stores temperature values
		
		for (int row = 0; row < temps.length; row++)						// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				temp[row][column] = temps[row][column];						// Set temperature values to two-dimensional array			
			}
		}
		return temp;														// Return temperature values 
	} 
// ------------------- End Get Temperatures Method -------------------
	
// ------------------- Make Copy Method -------------------
	/**
	 * Shallow copies the {@link Temperature} object.
	 * 
	 * @param obj  {@link Temperature} object to be shallow copied
	 */
	public void makeCopy(Temperature obj)
	{
		for (int row = 0; row < obj.temps.length; row++)					// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{																		 
				temps[row][column] = obj.temps[row][column];				// Shallow copy passed objects data to class's object 
			}
		}
	}
// ------------------- End Make Copy Method -------------------
	
// ------------------- Get Copy Method -------------------
	/**
	 * Retrieves a deep copy of the {@link Temperature} object.
	 * 
	 * @return  Deep copy of the {@link Temperature} object
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public Temperature getCopy() throws FileNotFoundException						
	{
		// Local variables
		Temperature tempObj = new Temperature();							// Store copy of object 

		for (int row = 0; row < tempObj.temps.length; row++)				// Iterate through each row of the two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				tempObj.temps[row][column] = temps[row][column]; 			// Deep copy class's temperature values to object 
			}
		}
		return tempObj;														// Return deep copy of object 
	}
// ------------------- End Get Copy Method -------------------
	
// ------------------- Copy Temperatures Method -------------------
	/**
	 * Deep copies a two-dimensional array of {@link #temps} and 
	 * returns it.
	 * 
	 * @param array  Two-dimensional array of {@link #temps} to 
	 * be deep copied
	 * 
	 * @return  Deep copied two-dimensional array of {@link #temps}
	 */
	public double[][] copyTemps(double[][] array)
	{
		// Local variables
		double[][] tempArray = new double[array.length][];					// Store copy of two-dimensional array
		
		for (int row = 0; row < array.length; row++)						// Iterate through each row of two dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of two-dimensional array
			{	
				tempArray[row][column] = array[row][column];				// Deep copy passed two-dimensional array data to local two dimensional array		
			}
		}
		return tempArray;													// Return deep copy of the temperatures
	}
// ------------------- End Copy Temperatures Method -------------------
	
// ------------------- Is Equal Method -------------------
	/**
	 * Determines if two {@link Temperature} objects are the same.
	 * 
	 * @param obj  {@link Temperature} object to be compared
	 * 
	 * @return  'true' if they are the same and 'false' if they are not the same
	 */
	public boolean isEqual(Temperature obj)
	{
		// Local variables
		boolean tempSame = false;											// Check if the temperature data is the same 
		
		for (int row = 0; row < temps.length; row++)						// Iterate through each row of two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of the two-dimensional array
			{
				if (temps[row][column] != obj.temps[row][column])			// Not the same temperature values 
				{
					tempSame = false;
				}
				else														// Same temperature values 
				{
					tempSame = true;
				}
			}
		}
		return tempSame;													// Return if the objects are the same 
	}
// ------------------- End Is Equal Method -------------------
	
// ------------------- Find the Same Method -------------------
	/**
	 * Determines if two two-dimensional arrays are the same.
	 * 
	 * @param arrOne  First two-dimensional array
	 * @param arrTwo  Second two-dimensional array
	 * 
	 * @return  'true' if they are the same and 'false' if they are not the same 
	 */
	public boolean findTheSame(double[][] arrOne, double[][] arrTwo)
	{
		if (arrOne.length != arrTwo.length)									// Two-dimensional arrays are not the same length
		{
			return false;													// Not the same two-dimensional arrays
		}
		else																// Same two-dimensional lengths
		{
			for (int row = 0; row < arrOne.length; row++)					// Iterate through each row of two-dimensional array
			{
				for (int column = 0; column < temps[row].length; column++)	// Iterate through each column of two-dimensional array
				{
					if (arrOne[row][column] != arrTwo[row][column])			// Temperature data is not the same 
					{
						return false;										// Not the same two-dimensional arrays
					}
				}
			}
		}
		return true;														// Same two-dimensional arrays
	}
// ------------------- End Find the Same Method -------------------

// ------------------- To String Method -------------------
	/**
	 * Converts the {@link Temperature} object's data to a String.
	 */
	public String toString()
	{
		// Local variables 
		String tempArray = ""; 												// Temporary temperature array
		String data = "";													// Temperature object data 
		
		for (int row = 0; row < temps.length; row++)						// Iterate through each row of two-dimensional array
		{
			for (int column = 0; column < temps[row].length; column++)		// Iterate through each column of two-dimensional array
			{
				if (row == 0 && column == 0)								// Highest temperatures
				{
					tempArray += "Highest Temperatures: ";					// Write the highest temperatures label
				}
				else if (row == 1 && column == 0)							// Lowest temperatures 
				{
					tempArray += "\nLowest Temperatures: ";					// Write the lowest temperatures label
				}
				else
				{
					tempArray += temps[row][column] + " ";					// Write the temperature data 
				}
			}
			data = ("The average temperatures for all of the months are: \n" + tempArray);
		}
		return data;														// Return temperature data 
	} 	
// ------------------- End To String Method -------------------
} // End of class Temperature