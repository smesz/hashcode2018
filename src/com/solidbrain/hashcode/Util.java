package com.solidbrain.hashcode;

import java.awt.Point;

public class Util {
	public static int getDistance(Point a, Point b){
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
