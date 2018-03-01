package com.solidbrain.hashcode.io;

public class LinesUtil {

	private static final String SPACE = " ";

	public int getFromLine(String line, int index) {
		String[] parts = line.split(SPACE);

		if (index >= parts.length) {
			throw new IllegalArgumentException("Something wrong with input!");
		}

		return Integer.parseInt(parts[index]);
	}
}
