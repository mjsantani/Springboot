package com.example.vehicle;

// class that handles the JSON input
public class VehicleInput {

	private int active;
	private Long vehicleId;
    private String latitude;
    private String longitude;
    
    public VehicleInput() {};

    public VehicleInput( int active, Long vehicleId, String latitude, String longitude) {
		super();
		this.active = active;
		this.vehicleId = vehicleId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
    
    public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehid(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}