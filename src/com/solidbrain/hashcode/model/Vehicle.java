package com.solidbrain.hashcode.model;

import java.awt.Point;
import java.util.List;

import com.solidbrain.hashcode.model.Ride;

public class Vehicle {
	public List<Ride> rides;

	public List<Ride> getRides() {
		return rides;
	}


	public int busyUntil = 0;
	public Point endCursePosition = new Point(0,0);


	public Vehicle(List<Ride> rides) {
		this.rides = rides;
	}
}
