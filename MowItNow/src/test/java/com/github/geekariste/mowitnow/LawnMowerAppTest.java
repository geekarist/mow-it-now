package com.github.geekariste.mowitnow;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.geekariste.mowitnow.Position.Direction;

public class LawnMowerAppTest {

	@Test
	public void testExecute() throws IOException, LawnMowerException {
		// Setup
		String[] args = new String[] { "src/test/resources/inputTestFile-nominal.txt" };
		Lawn lawn = new Lawn(5, 5);
		List<Position> expectedPositions = Arrays.asList(new Position(1, 3, Direction.N, lawn), new Position(5, 1,
				Direction.E, lawn));

		// Test
		LawnMowerApp app = new LawnMowerApp(args);
		app.execute();
		List<Position> result = app.getPositions();

		// Assert
		AssertUtils.assertListMatches(expectedPositions, result);
	}
}
