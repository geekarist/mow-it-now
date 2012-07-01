package com.github.geekariste.mowitnow;

import java.util.ArrayList;
import java.util.List;

public enum MowerInstruction {
	D("Right"), G("Left"), A("Forward");

	private String description;

	private MowerInstruction(String description) {
		this.description = description;
	}

	public static List<MowerInstruction> readFromLine(String readLine) {
		List<MowerInstruction> result = new ArrayList<MowerInstruction>();
		for (char c : readLine.toCharArray()) {
			MowerInstruction i = MowerInstruction.valueOf("" + c);
			result.add(i);
		}
		return result;
	}
	
	public String getDescription() {
		return description;
	}

}
