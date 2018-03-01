package com.solidbrain.hashcode;

import java.util.List;

import com.solidbrain.hashcode.io.InputReader;
import com.solidbrain.hashcode.io.OutputWriter;
import com.solidbrain.hashcode.model.Ride;

public class App {

	private static final String CASE_NAME = "a_example";

	private InputReader inputReader = new InputReader();
	private OutputWriter outputWriter = new OutputWriter();
	private SolutionFinder solutionFinder;

	public void process() {
		List<Ride> rides = inputReader.read("resource/input/" + CASE_NAME + ".in");

		Solution solution = solutionFinder.findSolution(rides);

		outputWriter.writeToFile(CASE_NAME, solution);
	}
}
