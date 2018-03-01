package com.solidbrain.hashcode;

import static com.solidbrain.hashcode.Util.getDistance;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.solidbrain.hashcode.model.Configuration;
import com.solidbrain.hashcode.model.Ride;
import com.solidbrain.hashcode.model.Vehicle;

public class Solver implements SolutionFinder {
	List<Ride> ridesToTake;
	List<Vehicle> vehicles;

	public Solution findSolution(List<Ride> rides) {
		ridesToTake = new ArrayList<>(rides);
		vehicles = new ArrayList<>();
		for (int i = 0; i < Configuration.vehicles; i++) {
			vehicles.add(new Vehicle(new ArrayList<>()));
		}

		for (int time = 0; time < Configuration.steps; time++) {
			System.out.println("time " + time);
			List<Vehicle> vehicles = getAvailableCars(time);
			for (Vehicle car : vehicles) {
				tryToFindRouteForVehicle(car, time);
			}
		}

		Solution s = new Solution(vehicles);
		return s;
	}

	private void tryToFindRouteForVehicle(Vehicle car, int time) {
		Map<Ride, Double> scores = new HashMap<>();
		for (Ride ride : ridesToTake) {
			double score = calculateScore(ride, car, time);
			scores.put(ride, score);
		}
		Ride ride = findBest(scores);
		if (ride != null) {
			car.rides.add(ride);
			ridesToTake.remove(ride);
			int timeToStartRide = getDistance(car.endCursePosition, ride.start);
			int waitTime = Math.max(ride.earliestStart - (time + timeToStartRide), 0);
			int timeRide = getDistance(ride.start, ride.end);
			car.busyUntil = time + timeToStartRide + timeRide + waitTime;
			car.endCursePosition = new Point(ride.end);
		}

	}

	//dont wait
	private Ride findBest(Map<Ride, Double> scores) {
		Ride found = null;
		for (Ride ride : scores.keySet()) {
			double score = scores.get(ride);
			if (score > 0 && (found == null || score > scores.get(found))) {
				found = ride;
			}
		}
		return found;
	}

	private List<Vehicle> getAvailableCars(int time) {
		return vehicles.stream()
				.filter(v -> v.busyUntil <= time)
				.collect(Collectors.toList());
	}

	private double calculateScore(Ride ride, Vehicle car, int time) {
		int toStartPoint = Util.getDistance(car.endCursePosition, ride.start);
		int distance = Util.getDistance(ride.start, ride.end);

		int timeToStart = time + toStartPoint;
		int timeFinish = time + toStartPoint + distance;

		//no points - no sense
		if (timeFinish > ride.latestFinish) {
			return -1;
		}
		double score = 1;
		//don't get route if too early - wait for options
		if (timeToStart < ride.earliestStart) {
			score = -((ride.earliestStart - timeToStart) / 3);
		}
		//if bonus
		if (timeToStart == ride.earliestStart) {
			score += Configuration.bonus;
		}
		score += distance;

		//		System.out.println("Route " + ride + " score : " + score);
		return score;
	}

}
