package com.solidbrain.hashcode.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.solidbrain.hashcode.Solution;
import com.solidbrain.hashcode.model.Ride;
import com.solidbrain.hashcode.model.Vehicle;

public class OutputWriter {

	public void writeToFile(String fileName, Solution solution) {
		List<String> lines = new ArrayList<>();

		for (Vehicle vehicle : solution.getVehicle()) {
			List<Ride> rides = vehicle.getRides();

			if (isEmpty(rides)) {
				lines.add("0");
			} else {
				lines.add("" + rides.size() + prepareLine(rides));
			}
		}

		String path = "resource/output/" + fileName + ".out";
		try {
			Files.write(Paths.get(path), lines);
		} catch (IOException e) {
			throw new IllegalStateException("Error while writing to file!", e);
		}
	}

	private boolean isEmpty(List<Ride> rides) {
		return rides == null || rides.size() == 0;
	}

	private String prepareLine(List<Ride> rides) {
		StringBuilder sb = new StringBuilder();

		for (Ride ride : rides) {
			sb.append(" ");
			sb.append(ride.index);
		}

		return sb.toString();
	}
}
