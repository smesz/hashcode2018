package com.solidbrain.hashcode.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.solidbrain.hashcode.Solution;

public class OutputWriter {

	public void writeToFile(String fileName, Solution solution) {
		List<String> lines = new ArrayList<>();

		// TODO all the logic

		String path = "resource/output/" + fileName + ".out";
		try {
			Files.write(Paths.get(path), lines);
		} catch (IOException e) {
			throw new IllegalStateException("Error while writing to file!", e);
		}
	}

}
