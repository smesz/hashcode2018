package com.solidbrain.hashcode.test;

import java.awt.Point;
import java.util.Arrays;

import com.solidbrain.hashcode.SolutionValidator;
import com.solidbrain.hashcode.model.Ride;
import com.solidbrain.hashcode.model.Vehicle;

public class TestSolutionValidator {
	public static void main(String[] args) {
		SolutionValidator solutionValidator = new SolutionValidator();

		//ride to long
		try {
		Ride ride = new Ride(new Point(0, 0), new Point(2, 2), 0, 2);
		solutionValidator
				.validateCarRoute(new Vehicle(Arrays.asList(ride)));
		} catch (IllegalStateException e) {
			System.out.println("ok");
		}

		//ok ride
		Ride ride = new Ride(new Point(0, 0), new Point(2, 2), 0, 4);

		solutionValidator
				.validateCarRoute(new Vehicle(Arrays.asList(ride)));

		//two rides from starting position
		try {
			Ride ride2 = new Ride(new Point(2, 2), new Point(3, 3), 0, 4);
			solutionValidator
					.validateCarRoute(new Vehicle(Arrays.asList(ride, ride2)));
		} catch (IllegalStateException e) {
			System.out.println("ok");
		}


		//one ride after another
		try {
			Ride ride3 = new Ride(new Point(0, 0), new Point(3, 3), 0, 7);
			Ride ride4 = new Ride(new Point(2, 2), new Point(3, 3), 0, 4);
			solutionValidator
					.validateCarRoute(new Vehicle(Arrays.asList(ride3, ride4)));
		} catch (IllegalStateException e) {
			System.out.println("ok");
		}

		//one ride after another 2
		try {
			Ride ride5 = new Ride(new Point(0, 0), new Point(3, 3), 0, 7);
			Ride ride6 = new Ride(new Point(2, 2), new Point(3, 3), 0, 9);
			solutionValidator
					.validateCarRoute(new Vehicle(Arrays.asList(ride5, ride6)));
		} catch (IllegalStateException e) {
			System.out.println("ok");
		}

	}
}
