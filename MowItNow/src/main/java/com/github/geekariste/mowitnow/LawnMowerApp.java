package com.github.geekariste.mowitnow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LawnMowerApp {

	private Reader reader;
	private List<LawnMower> mowers = new ArrayList<LawnMower>();

	public LawnMowerApp(String[] args) throws FileNotFoundException {
		reader = openInstructionsReader(args);
	}

	public void execute() throws IOException, LawnMowerException {
		LawnMowerInput mowerInput = new LawnMowerInput(reader);
		for (LawnMowerProgramming programming : mowerInput.getProgrammingList()) {
			LawnMower mower = new LawnMower(programming.getInitialPosition());
			mower.execute(programming.getInstructions());
			mowers.add(mower);
		}
	}

	public List<Position> getPositions() {
		List<Position> result = new ArrayList<Position>();
		for (LawnMower m : mowers) {
			result.add(m.getPosition());
		}
		return result;
	}

	private static Reader openInstructionsReader(String[] args) throws FileNotFoundException {
		Reader reader;
		if (args.length == 0) {
			reader = new InputStreamReader(System.in);
		} else {
			reader = new FileReader(args[0]);
		}
		return reader;
	}
}
