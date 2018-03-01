package com.solidbrain.hashcode.model;

import java.awt.Point;

public class Ride {

	public Point start;
	public Point end;

	public int earliestStart;
	public int latestFinish;

	public Ride(Point start, Point end, int earliestStart, int latestFinish) {
		this.start = start;
		this.end = end;
		this.earliestStart = earliestStart;
		this.latestFinish = latestFinish;
	}
}
