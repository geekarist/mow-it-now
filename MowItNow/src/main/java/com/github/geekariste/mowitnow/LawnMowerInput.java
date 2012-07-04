package com.github.geekariste.mowitnow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LawnMowerInput {

	private Lawn lawn;
	private List<LawnMowerProgramming> programmingList = new ArrayList<LawnMowerProgramming>();

	public LawnMowerInput(Reader reader) throws IOException {
		BufferedReader bufReader = new BufferedReader(reader);
		lawn = loadLawn(bufReader);
		while (bufReader.ready()) {
			LawnMowerProgramming programming = loadProgramming(bufReader);
			programmingList.add(programming);
		}
	}

	private LawnMowerProgramming loadProgramming(BufferedReader bufReader) throws IOException {
		Position initialPosition = Position.readPositionFromLine(bufReader.readLine(), lawn);
		List<MowerInstruction> instructions = MowerInstruction.readFromLine(bufReader.readLine());
		LawnMowerProgramming programming = new LawnMowerProgramming(initialPosition, instructions);
		return programming;
	}

	private Lawn loadLawn(BufferedReader bufReader) throws IOException {
		String readLine = bufReader.readLine();
		Scanner scanner = new Scanner(readLine);
		int lastX = scanner.nextInt();
		int lastY = scanner.nextInt();
		Lawn l = new Lawn(lastX, lastY);
		return l;
	}

	public List<LawnMowerProgramming> getProgrammingList() {
		return programmingList;
	}
	
	public Lawn getLawn() {
		return lawn;
	}

}
