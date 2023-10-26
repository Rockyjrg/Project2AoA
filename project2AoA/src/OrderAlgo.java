import java.util.*;
import java.io.*;

public class OrderAlgo {
	
	public String name;
	public ArrayList<Store> stores;
	public ArrayList<User> query;
	
	public OrderAlgo( String name ) {
		stores = new ArrayList<Store>();
		query = new ArrayList<User>();
	}
	
	//method to add the store to the ArrayList if it isn't empty
	public void addStore(Store store) {
		if ( store != null ) {
			stores.add(store);
		}
	}
	
	//method to add each query to the ArrayList if != empty
	public void readQueries( User querys ) {
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
				User query = new User( Double.parseDouble( tokens[0] ), Double.parseDouble( tokens[1] ), Integer.parseInt(tokens[2]));
				this.readQueries(query);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//close the file
		scan.close();
	}
	
	//Compute the distance with the haversine formula
	//given in the store.java class
	public void computeDistance() {
		//iterate through each 'User' object in query
		//and calculate the distance between the coordinates
		//and each store
		for (User user : query) {
			for (Store store : stores) {
				store.computeDistance(user.otherLat, user.otherLong);
			}
		}
	}
	
	//Parititon algorithm to be used in the Rand-Select algorithm
	//to partition the array in two subproblems
	public int partition(ArrayList<Store> stores, int left, int right) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(right - left + 1) + left;
		
		//Swap random pivot with left element
		Store pivotStore = stores.get(randomIndex);
		stores.set(randomIndex, stores.get(left));
		stores.set(left, pivotStore);
		
		double pivot = pivotStore.getDistance();
		int i = left;
		
		for (int j = left + 1; j <= right; j++) {
			if (stores.get(j).getDistance() <= pivot) {
				i++;
				//Swap stores[i] and stores[j]
				Store temp = stores.get(i);
				stores.set( i, stores.get(j) );
				stores.set(j, temp);
			}
		}
		
		//Swap stores[left] and stores[i]
		Store temp = stores.get(left);
		stores.set(left, stores.get(i));
		stores.set(i, temp);
		
		return i;
	}
	
	public Store randSelect(Array<Store> stores, int left, int right, int i) {
		
	}
	
}
	

