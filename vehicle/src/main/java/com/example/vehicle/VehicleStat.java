package com.example.vehicle;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="vehiclestatus")
@EntityListeners(AuditingEntityListener.class)
public class VehicleStat implements Serializable {
	
	@Column
	@Id
	private long vehid;
	
	@Column
	private String latitude;
    
	@Column
	private String longitude;
    
	@Column
	private String address;
	
	public VehicleStat() {};

    public VehicleStat(long vehid, String latitude, String longitude, String address) {
		super();
		this.vehid = vehid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

    public long getVehid() {
		return vehid;
	}

	public void setVehid(long vehid) {
		this.vehid = vehid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}