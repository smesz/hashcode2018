package com.solidbrain.hashcode.model;

import java.util.List;

public class Vehicle {
	public List<Ride> rides;

	public List<Ride> getRides() {
		return rides;
	}

	public Vehicle(List<Ride> rides) {
		this.rides = rides;
	}
}
