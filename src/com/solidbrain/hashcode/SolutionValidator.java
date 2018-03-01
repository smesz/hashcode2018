package com.solidbrain.hashcode;

import java.awt.Point;

import com.solidbrain.hashcode.model.Configuration;
import com.solidbrain.hashcode.model.Ride;
import com.solidbrain.hashcode.model.Vehicle;

public class SolutionValidator {

	int points;

	public void validate(Solution solution) {
		for (Vehicle v : solution.getVehicle()) {
			validateCarRoute(v);
		}
		if(Configuration.vehicles < solution.getVehicle().size()){
			throw new IllegalStateException("To many vehicles");
		}
	}

	private void validateCarRoute(Vehicle v) {
		int time = 0;
		Point carPosition = new Point(0, 0);
		for (Ride r : v.getRides()) {
			//go to route start
			int distance = Util.getDistance(r.start, carPosition);
			time += distance;
			//wait until earliest Start
			if (time <= r.earliestStart) {
				time = r.earliestStart;
				points += Configuration.bonus;
			}
			int routeDistance = Util.getDistance(r.start, r.end);
			points += routeDistance;
			time += routeDistance;

			if (time > r.latestFinish) {
				throw new IllegalStateException("Car : " + v + " not finished route " + r);
			}
		}
	}

}
