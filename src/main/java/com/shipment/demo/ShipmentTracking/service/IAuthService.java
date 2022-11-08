package com.shipment.demo.ShipmentTracking.service;

import java.util.List;

import com.shipment.demo.ShipmentTracking.entity.User;

public interface IAuthService {

	User register(User user);

	User login(User user);
	
	List<User> getAll();

}
