//Class for the user to account for the queries.csv data

public class User {
	public double latitude;
	public double longitude;
	public int numStoresDesired;
	
	public User(double userLat, double userLong, int numStoresDesired) {
		userLat = latitude;
		userLong = longitude;
		this.numStoresDesired = numStoresDesired;
	}
}
