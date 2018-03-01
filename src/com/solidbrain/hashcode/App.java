package com.solidbrain.hashcode;

import java.util.List;

import com.solidbrain.hashcode.io.InputReader;
import com.solidbrain.hashcode.model.Ride;

public class App {

	private static final String PATH = "resource/input/a_example.in";

	private InputReader inputReader = new InputReader();

	public void process() {
		List<Ride> rides = inputReader.read(PATH);

		rides.forEach(ride -> {
			System.out.println(ride);
		});

	}

}
