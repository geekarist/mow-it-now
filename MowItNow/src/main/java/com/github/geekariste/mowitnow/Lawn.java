package com.github.geekariste.mowitnow;

public class Lawn {

	private int lastY;
	private int lastX;

	public Lawn(int x, int y) {
		lastX = x;
		lastY = y;
	}

	public int getLastY() {
		return lastY;
	}

	public int getLastX() {
		return lastX;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lastX;
		result = prime * result + lastY;
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
		Lawn other = (Lawn) obj;
		if (lastX != other.lastX)
			return false;
		if (lastY != other.lastY)
			return false;
		return true;
	}

}
