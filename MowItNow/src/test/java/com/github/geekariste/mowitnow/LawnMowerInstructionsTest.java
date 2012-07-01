package com.github.geekariste.mowitnow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.github.geekariste.mowitnow.Position.Direction;

public class LawnMowerInstructionsTest {

	@Test
	public void testLawn() throws IOException {
		LawnMowerInput instructions = new LawnMowerInput(new FileReader(
				"src/test/resources/inputTestFile.txt"));
		Lawn lawn = instructions.getLawn();
		Assert.assertEquals(6, lawn.getSizeX());
		Assert.assertEquals(6, lawn.getSizeY());
	}

	@Test
	public void testLawnMowerProgrammingList() throws FileNotFoundException, IOException {
		List<MowerInstruction> instructions1 = Arrays.asList(MowerInstruction.G, MowerInstruction.A,
				MowerInstruction.G, MowerInstruction.A, MowerInstruction.G, MowerInstruction.A, MowerInstruction.G,
				MowerInstruction.A, MowerInstruction.A);
		List<MowerInstruction> instructions2 = Arrays.asList(MowerInstruction.A, MowerInstruction.A,
				MowerInstruction.D, MowerInstruction.A, MowerInstruction.A, MowerInstruction.D, MowerInstruction.A,
				MowerInstruction.D, MowerInstruction.D, MowerInstruction.A);
		Lawn lawn = new Lawn(6, 6);
		List<LawnMowerProgramming> expected = Arrays.asList( //
				new LawnMowerProgramming(new Position(1, 2, Direction.N, lawn), instructions1), //
				new LawnMowerProgramming(new Position(3, 3, Direction.E, lawn), instructions2));

		FileReader reader = new FileReader("src/test/resources/inputTestFile.txt");
		LawnMowerInput instructions = new LawnMowerInput(reader);
		List<LawnMowerProgramming> lawnMowerProgrammingList = instructions.getProgrammingList();
		AssertUtils.assertListMatches(expected, lawnMowerProgrammingList);
	}
}
