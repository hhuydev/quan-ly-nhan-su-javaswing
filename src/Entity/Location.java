package Entity;

public class Location {

	private int locationID;
	private String locationName;
	private double locationAllowance;
	private int numberOfEmployees;
	private int toTransferCount;
	private int fromTransferCount;

	public Location(int locationID, String locationName, double locationAllowance) {
		this.locationID = locationID;
		this.locationName = locationName;
		this.locationAllowance = locationAllowance;
	}

	public Location(int locationID) {
		super();
		this.locationID = locationID;
	}

	public Location(int locationID, String locationName, double locationAllowance, int numberOfEmployees,
			int toTransferCount, int fromTransferCount) {
		super();
		this.locationID = locationID;
		this.locationName = locationName;
		this.locationAllowance = locationAllowance;
		this.numberOfEmployees = numberOfEmployees;
		this.toTransferCount = toTransferCount;
		this.fromTransferCount = fromTransferCount;
	}

	public Location(String locationName, double locationAllowance) {
		this.locationName = locationName;
		this.locationAllowance = locationAllowance;
	}

	public Location() {
	}

	public int getFromTransferCount() {
		return fromTransferCount;
	}

	public double getLocationAllowance() {
		return locationAllowance;
	}

	public int getLocationID() {
		return locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public int getToTransferCount() {
		return toTransferCount;
	}

	public void setFromTransferCount(int fromTransferCount) {
		this.fromTransferCount = fromTransferCount;
	}

	public void setLocationAllowance(double locationAllowance) {
		this.locationAllowance = locationAllowance;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public void setToTransferCount(int toTransferCount) {
		this.toTransferCount = toTransferCount;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
}
