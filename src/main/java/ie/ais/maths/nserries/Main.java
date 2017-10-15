package ie.ais.maths.nserries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static final  int 	 number_of_test_cases_limt = 10; 
	private static final  long  limit = 10000000000000000l;		// max number of Nth term 
	private static final  long  moduo = 1000000007;				// moduo

	public static void main(String[] args) {
		int number_of_test_cases = 0;
		ArrayList<Long> listOfNTerms = new ArrayList<Long>();
		String input = null;  // variable to keep input value
		System.out.println("Enter values for test cases following with pressing ENTER");
		 
		try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number_of_test_cases = Integer.parseInt(input);
	        if((number_of_test_cases  > number_of_test_cases_limt)|| (number_of_test_cases==0))
	        {
	        	System.err.println("Limit exceeded:" + number_of_test_cases);
	        	throw new NumberFormatException("Limit exceeded");
	        }
	    } catch (NumberFormatException ex) {
		       System.out.println("Not a number !");
		       return;
	    } catch (IOException e) {
	    	   e.printStackTrace();
		       return;
	    }
		// starting to enter values for nth term
		int idx = 0;
		Main main = new Main();
		idx = main.captureNTermsFromConsole(number_of_test_cases, listOfNTerms, idx);
		main.calculateModuoForGivenNumberOfTestCasesAndListOfNTerms(number_of_test_cases, listOfNTerms);
	}

	private int captureNTermsFromConsole(int number_of_test_cases, ArrayList<Long> listOfNTerms, int idx) {
		String input;
		while (idx < number_of_test_cases)
		{
			try {
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        input = bufferedReader.readLine();
		        if (!isNumber(input.trim()))	
        		{
		        	System.err.println("Something is wrong");
		        	throw new NumberFormatException("Wrong Number");
        		}
		        Long longValue = Long.parseLong(input);
		        if( (longValue > limit)|| (longValue==0))
		        {
		        	System.err.println("Limit exceeded:" + longValue);
		        	throw new NumberFormatException("Limit exceeded");
		        }
		        listOfNTerms.add(longValue);
				idx++;
		    } catch (NumberFormatException ex) {
		       System.out.println("Wrong number !");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		return idx;
	}

	public void calculateModuoForGivenNumberOfTestCasesAndListOfNTerms(int number_of_test_cases,
			ArrayList<Long> listOfNTerms) {
		double suma = 0.0;
		for (int i = 0; i < number_of_test_cases; i++) 
		{
				System.out.println("Case " + listOfNTerms.get(i).doubleValue());
			    suma = listOfNTerms.get(i).doubleValue() * listOfNTerms.get(i).doubleValue();
				System.out.println("Sum:: "+ (long)(suma % moduo));
		}
	}


	private boolean isNumber(String toTest) {
	    return toTest.matches("^[1-9]{1}\\d{0,16}$");
	}
	
}
