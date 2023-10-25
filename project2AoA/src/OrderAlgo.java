import java.util.*;
import java.io.*;

public class OrderAlgo {
	
	public String name;
	public ArrayList<Store> stores;
	public ArrayList<Store> query;
	
	public OrderAlgo( String name ) {
		stores = new ArrayList<Store>();
		query = new ArrayList<Store>();
	}
	
	//method to add the store to the ArrayList if it isn't empty
	public void addStore(Store store) {
		if ( store != null ) {
			stores.add(store);
		}
	}
	
	//method to add each query to the ArrayList if != empty
	public void addQuery( Store querys ) {
		if ( querys != null ) {
			query.add(querys);
		}
	}
	
	//Method to open the data file and store our data into the ArrayList store
	public void addStore( String filename ) {
		File file = new File( filename );
		Scanner scan = null;
		try {
			scan = new Scanner( file );
			
			if (scan.hasNextLine()) {
				scan.nextLine();
			}
			
			while( scan.hasNextLine() ) {
				
				String line = scan.nextLine();
				
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				
				Store store = new Store(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
				this.addStore(store);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//close the file
		scan.close();
	}
	
	//method to open the query file and read the info
	public void readQueries( String queryFileName ) {
		File file = new File( queryFileName );
		Scanner scan = null;
		try {
			scan = new Scanner( file );
			//skip first line
			if( scan.hasNextLine() ) {
				scan.nextLine();
			}
			//read through each line
			while( scan.hasNextLine() ) {
				String line = scan.nextLine();
				String tokens[] = line.split(",");
				Store query = new Store( tokens[0], tokens[1], tokens[2] );
				this.addQuery(query);
			}
		}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//close the file
		scan.close();
		
	}
	
}
