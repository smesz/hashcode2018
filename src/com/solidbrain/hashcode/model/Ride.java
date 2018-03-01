package com.solidbrain.hashcode.model;

import java.awt.Point;

public class Ride {

	public int index;

	public Point start;
	public Point end;

	public int earliestStart;
	public int latestFinish;

	public Ride(int index, Point start, Point end, int earliestStart, int latestFinish) {
		this.index = index;
		this.start = start;
		this.end = end;
		this.earliestStart = earliestStart;
		this.latestFinish = latestFinish;
	}

	@Override
	public String toString() {
		return "Ride{" +
				"index=" + index +
				", start=" + start +
				", end=" + end +
				", earliestStart=" + earliestStart +
				", latestFinish=" + latestFinish +
				'}';
	}
}
