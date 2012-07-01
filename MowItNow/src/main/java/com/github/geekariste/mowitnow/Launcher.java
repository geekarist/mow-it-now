package com.github.geekariste.mowitnow;

import java.io.IOException;
import java.util.List;


public class Launcher {
	public static void main(String[] args) throws IOException, LawnMowerException {
		System.out.println("Please enter input data.");
		LawnMowerApp app = new LawnMowerApp(args);
		app.execute();
		List<Position> positions = app.getPositions();
		System.out.println("Final mower positions are : ");
		for (Position p : positions) {
			System.out.println(p);
		}
	}
}
