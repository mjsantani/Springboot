package com.example.vehicle;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class VehicleStatDal {
	@Autowired
	VehicleStatRepository vsr;
	
	@Autowired
	HttpClient httpClient;
	
	public void deleteVehicleStat(VehicleInput vehInput) {
		vsr.delete(vehInput.getVehicleId());
	}
	
	public void addVehicleStat(VehicleInput vehInput) throws ParseException, IOException {
		VehicleStat vehicleStat = vsr.findOne(vehInput.getVehicleId());
		
		// entry already exists so just updating the old one.
		if(vehicleStat != null) {
			vehicleStat.setLongitude(vehInput.getLongitude());
			vehicleStat.setLatitude(vehInput.getLatitude());
			
//			String request = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+vehInput.getLatitude()+","+vehInput.getLongitude()+"&result_type=street_address&key=AIzaSyAtJSGhm2A-Hn9clmn5HxcCn1cjBePV_hA";
//			HttpGet httpGet = new HttpGet(request);
//		    HttpResponse response = httpClient.execute(httpGet);
//		    String address = EntityUtils.toString(response.getEntity());
//		    vehicleStat.setAddress(address);
		    
			vehicleStat.setAddress("testing");
		    vsr.save(vehicleStat);
		} else { 
			//entry doesn't exist so create a new one.
//			String request = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+vehInput.getLatitude()+","+vehInput.getLongitude()+"&result_type=street_address&key=AIzaSyAtJSGhm2A-Hn9clmn5HxcCn1cjBePV_hA";
//			HttpGet httpGet = new HttpGet(request);
//		    HttpResponse response = httpClient.execute(httpGet);
//		    String address = EntityUtils.toString(response.getEntity());

		    String address = "testing again";
		    vsr.save(new VehicleStat(vehInput.getVehicleId(), vehInput.getLongitude(),
		    		vehInput.getLatitude(), address));
		}
	}
}
