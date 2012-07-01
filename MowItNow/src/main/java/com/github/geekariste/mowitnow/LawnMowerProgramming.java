package com.github.geekariste.mowitnow;

import java.util.List;

public class LawnMowerProgramming {

	private Position initialPosition;
	private List<MowerInstruction> instructions;

	public LawnMowerProgramming(Position position, List<MowerInstruction> instructions) {
		this.initialPosition = position;
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "LawnMowerProgramming [instructions=" + instructions + ", initialPosition=" + initialPosition + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initialPosition == null) ? 0 : initialPosition.hashCode());
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LawnMowerProgramming other = (LawnMowerProgramming) obj;
		if (initialPosition == null) {
			if (other.initialPosition != null)
				return false;
		} else if (!initialPosition.equals(other.initialPosition))
			return false;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		return true;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public List<MowerInstruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<MowerInstruction> instructions) {
		this.instructions = instructions;
	}

}
