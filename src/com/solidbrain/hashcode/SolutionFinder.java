package com.solidbrain.hashcode;

import java.util.List;

import com.solidbrain.hashcode.model.Ride;

public interface SolutionFinder {

	Solution findSolution(List<Ride> rides);
}
