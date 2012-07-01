package com.github.geekariste.mowitnow;

import java.util.List;

public class LawnMower {

	private Position position;

	public LawnMower() {
	}

	public LawnMower(Position initialPosition) {
		this.position = initialPosition;
	}

	public void execute(List<MowerInstruction> list) throws LawnMowerException {
		for (MowerInstruction i : list) {
			position.move(i);
		}
	}

	public Position getPosition() {
		return position;
	}

}
