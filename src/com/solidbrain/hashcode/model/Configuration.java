package com.solidbrain.hashcode.model;

public class Configuration {

	public static int rows;
	public static int columns;
	public static int vehicles;
	public static int rides;
	public static int bonus;
	public static int steps;

	public static String toString1() {
		return "rows:" + rows + ", columns: " + columns + ", vehicles: " + vehicles + ", rides: " + rides + ", bonus: "
				+ bonus + ", steps: " + steps;
	}
}
