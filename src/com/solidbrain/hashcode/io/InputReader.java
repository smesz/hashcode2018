package com.solidbrain.hashcode.io;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.solidbrain.hashcode.model.Configuration;
import com.solidbrain.hashcode.model.Ride;

public class InputReader {

	private LinesUtil linesUtil = new LinesUtil();

	public List<Ride> read(String path) {
		try {
			Stream<String> linesStream = Files.lines(Paths.get(path));
			List<String> lines = linesStream.collect(Collectors.toList());

			Iterator<String> iterator = lines.iterator();

			String line = iterator.next();
			Configuration.rows = linesUtil.getFromLine(line, 0);
			Configuration.columns = linesUtil.getFromLine(line, 1);
			Configuration.vehicles = linesUtil.getFromLine(line, 2);
			Configuration.rides = linesUtil.getFromLine(line, 3);
			Configuration.bonus = linesUtil.getFromLine(line, 4);
			Configuration.steps = linesUtil.getFromLine(line, 5);

			List<Ride> rides = new ArrayList<>();

			while (iterator.hasNext()) {
				line = iterator.next();
				rides.add(extractRide(line));
			}

			return rides;

		} catch (IOException e) {
			throw new IllegalArgumentException("Error while parsing input data", e);
		}
	}

	private Ride extractRide(String line) {
		Point start = new Point(linesUtil.getFromLine(line, 1), linesUtil.getFromLine(line, 0));
		Point end = new Point(linesUtil.getFromLine(line, 3), linesUtil.getFromLine(line, 2));

		return new Ride(start, end, linesUtil.getFromLine(line, 4), linesUtil.getFromLine(line, 5));
	}

}
