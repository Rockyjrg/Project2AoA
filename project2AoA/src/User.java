//Class for the user to account for the queries.csv data

public class User {
	public double otherLat;
	public double otherLong;
	public int numStoresDesired;
	
	public User(double otherLat, double otherLong, int numStoresDesired) {
		this.otherLat = otherLat;
		this.otherLong = otherLong;
		this.numStoresDesired = numStoresDesired;
	}
}
