package com.github.geekariste.mowitnow;

import java.util.Scanner;

public class Position {

	public static enum Direction {
		N, E, W, S
	}

	private int x;
	private int y;
	private Direction direction;
	private Lawn lawn;

	public static Position readPositionFromLine(String line, Lawn lawn) {
		Scanner scanner = new Scanner(line);
		int initialX = scanner.nextInt();
		int initialY = scanner.nextInt();
		String initialDirectionStr = scanner.next();
		Direction initialDirection = Direction.valueOf(initialDirectionStr);
		Position initialPosition = new Position(initialX, initialY, initialDirection, lawn);
		return initialPosition;
	}

	public Position(int x, int y, Direction d, Lawn lawn) {
		this.x = x;
		this.y = y;
		this.direction = d;
		this.lawn = lawn;
	}

	public void move(MowerInstruction i) throws LawnMowerException {
		if (i == MowerInstruction.D) {
			turnRight();
		} else if (i == MowerInstruction.G) {
			turnLeft();
		} else if (i == MowerInstruction.A) {
			moveForward();
		} else {
			throw new LawnMowerException("Unknown mower instruction: " + i);
		}
	}

	private void moveForward() {
		if (direction == Direction.N && y < lawn.getSizeY()){
			y++;
		} else if (direction == Direction.W && x > 0) {
			x--;
		} else if (direction == Direction.S && y > 0) {
			y--;
		} else if (direction == Direction.E && x < lawn.getSizeX()) {
			x++;
		}
	}

	private void turnLeft() throws LawnMowerException {
		if (direction == Direction.N) {
			direction = Direction.W;
		} else if (direction == Direction.W) {
			direction = Direction.S;
		} else if (direction == Direction.S) {
			direction = Direction.E;
		} else if (direction == Direction.E) {
			direction = Direction.N;
		} else {
			throw new LawnMowerException("Unknown direction: " + direction);
		}
	}

	private void turnRight() throws LawnMowerException {
		if (direction == Direction.N) {
			direction = Direction.E;
		} else if (direction == Direction.W) {
			direction = Direction.N;
		} else if (direction == Direction.S) {
			direction = Direction.W;
		} else if (direction == Direction.E) {
			direction = Direction.S;
		} else {
			throw new LawnMowerException("Unknown direction: " + direction);
		}
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (direction != other.direction)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}