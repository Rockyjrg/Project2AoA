//Class for the user to account for the queries.csv data

public class User {
	public double queryLat;
	public double queryLong;
	public int numStoresDesired;
	
	public User(double queryLat, double queryLong, int numStoresDesired) {
		this.queryLat = queryLat;
		this.queryLong = queryLong;
		this.numStoresDesired = numStoresDesired;
	}

	public double getQueryLat() {
		return queryLat;
	}

	public void setQueryLat(double queryLat) {
		this.queryLat = queryLat;
	}

	public double getQueryLong() {
		return queryLong;
	}

	public void setQueryLong(double queryLong) {
		this.queryLong = queryLong;
	}

	public int getNumStoresDesired() {
		return numStoresDesired;
	}

	public void setNumStoresDesired(int numStoresDesired) {
		this.numStoresDesired = numStoresDesired;
	}
	
}
