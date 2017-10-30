package com.example.vehicle;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleController {
	
	@Autowired
	VehicleStatRepository vsr;
	
	@RequestMapping(value="/getVehicle", method=RequestMethod.GET)
	public String getVehicle() {
		return "Get Vehicle";
	}
	
	@RequestMapping(value="/setVehicleStatus", method=RequestMethod.POST)
	public Response getVehicleStatus(@RequestBody VehicleInput vehInput) throws ParseException, IOException{
		System.out.println(vehInput.getVehicleId());
		VehicleStat vehicleStat = vsr.findOne(vehInput.getVehicleId());
		
		// entry already exists so just updating the old one.
		if(vehicleStat != null) {
			vehicleStat.setLongitude(vehInput.getLongitude());
			vehicleStat.setLatitude(vehInput.getLatitude());
			
			String request = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+vehInput.getLatitude()+","+vehInput.getLongitude()+"&result_type=street_address&key=AIzaSyAtJSGhm2A-Hn9clmn5HxcCn1cjBePV_hA";
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(request);
		    CloseableHttpResponse response = httpClient.execute(httpGet);
		    String address = EntityUtils.toString(response.getEntity());
		    vehicleStat.setAddress(address);
		    
			vehicleStat.setAddress("testing");
		    vsr.save(vehicleStat);
		    return (new Response(1, "Vehicle information saved."));
		} else { 
			//entry doesn't exist so create a new one.
//			String request = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+vehInput.getLatitude()+","+vehInput.getLongitude()+"&result_type=street_address&key=AIzaSyAtJSGhm2A-Hn9clmn5HxcCn1cjBePV_hA";
//			HttpGet httpGet = new HttpGet(request);
//		    HttpResponse response = httpClient.execute(httpGet);
//		    String address = EntityUtils.toString(response.getEntity());

		    String address = "testing again";
		    vsr.save(new VehicleStat(vehInput.getVehicleId(), vehInput.getLongitude(),
		    		vehInput.getLatitude(), address));
		    return (new Response(1, "Vehicle information saved."));
		}
		
	}

}
