package com.solidbrain.hashcode.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

	private LinesUtil linesUtil = new LinesUtil();

	public void read(String path) {
		try {
			Stream<String> linesStream = Files.lines(Paths.get(path));
			List<String> lines = linesStream.collect(Collectors.toList());

			Iterator<String> iterator = lines.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (IOException e) {
			throw new IllegalArgumentException("Error while parsing input data", e);
		}
	}
}
