

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ReadCaverns {

	
	
	public static void main(String[] args) throws IOException {
		// Open input.cav
		BufferedReader br = new BufferedReader(new FileReader("input.cav"));
		
		//Read the line of comma separated text from the file
		String buffer = br.readLine(); 
		System.out.println("Raw data : " + buffer);
		
		br.close();
		
		//Convert the data to an array
		String[] data = buffer.split(",");
		
		//Now extract data from the array
        //note that we need to convert from String to int as we go
		int noOfCaves = Integer.parseInt(data[0]);
		System.out.println ("There are " + noOfCaves + " caves.");
		
		//Get coordinates
		for (int count = 1; count < ((noOfCaves*2)+1); count=count+2){
			System.out.println("Cave at " + data[count] +"," +data[count+1]);
			
		
		}
		
	
		
		//Build connectivity matrix
		
		//Declare the array
		boolean[][] connected = new boolean[noOfCaves][];
		
		for (int row= 0; row < noOfCaves; row++){
			connected[row] = new boolean[noOfCaves];
		}
		//Now read in the data - the starting point in the array is after the coordinates 
		int col = 0;
		int row = 0;
		
		for (int point = (noOfCaves*2)+1 ; point < data.length; point++){
			//Work through the array
			
			if (data[point].equals("1"))
			   connected[row][col] = true;
			else
				connected[row][col] = false;
				
			col++;
			if (col == noOfCaves){ 
				col=0;
				row++;
			}
		}
		//Connected now has the adjacency matrix within it 
		System.out.println(connected);
		
		//To find out if two caves 5 and 6 are connected.....
		int cave1 = 5;
		int cave2 = 6;
		
		boolean areConnected = connected[cave1-1][cave2-1]; 
		System.out.println("Cave " + cave1 + " and cave " + cave2 +" are connected: "+ areConnected);

	}

}