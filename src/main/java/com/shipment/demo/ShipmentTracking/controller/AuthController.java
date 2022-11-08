package com.shipment.demo.ShipmentTracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipment.demo.ShipmentTracking.entity.User;
import com.shipment.demo.ShipmentTracking.service.IAuthService;



@RestController
@Scope("request")
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	@Qualifier("User")
	@Autowired
	private IAuthService authService;

	@PostMapping(value="/register" , produces= {MediaType.APPLICATION_JSON_VALUE})
	public User Register(@RequestBody User user) {
		return authService.register(user);

	}

	@PostMapping(value="/login" , produces= {MediaType.APPLICATION_JSON_VALUE})
	public User login(@RequestBody User user) {
		return authService.login(user);

	}
	@GetMapping(value="/getAll", produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public List<User> getAll(){
		return authService.getAll();
	}
}
