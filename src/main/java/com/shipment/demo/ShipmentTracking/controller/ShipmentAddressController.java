package com.shipment.demo.ShipmentTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipment.demo.ShipmentTracking.entity.ShipmentAddress;
import com.shipment.demo.ShipmentTracking.service.IShipmentAddressService;

@RestController
@Scope("request")
@RequestMapping("/ship")
public class ShipmentAddressController {
	@Autowired
	@Qualifier("shipmentaddressservice")
	private IShipmentAddressService shipmentaddress;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String dummy() {
		return "working";
	}

	@PostMapping(value = "/add", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ShipmentAddress add(@RequestBody ShipmentAddress address) {
		
		return shipmentaddress.add(address);
	}
	
	@PutMapping(value="/update",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ShipmentAddress update(@RequestBody ShipmentAddress address) {
		
		return shipmentaddress.update(address);
	}
	@GetMapping(value="/getall",produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ShipmentAddress> getAll() {
		
		return shipmentaddress.getAll();
	}
	@DeleteMapping(value="/deletebydatemob/{dateMob}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteBydateMob(@PathVariable Integer id) {
		
		shipmentaddress.deleteById(id);
	}
	@GetMapping(value="/getbyid/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ShipmentAddress getById(@PathVariable("id") Integer id) {
		
		return shipmentaddress.getById(id);
	}
	@GetMapping(value="/getbyfirstname/{firstName}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ShipmentAddress getByFirstName(@PathVariable("firstName")String firstName) {
		
		return shipmentaddress.getByFirstName(firstName);
	}
	@GetMapping(value="/getbymobno/{mobileNo}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ShipmentAddress getByMobileNo(@PathVariable("mobileNo")String mobileNo) {
		
		return shipmentaddress.getByMobileNo(mobileNo);
	}

}
