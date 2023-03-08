package org.example;

import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	static String[][] array = {
			{"11020", "viel Sonne"},
			{"12020", "nicht so viel Sonne"},
			{"11420", "viel Sonne"},
			{"11520", "keine Sonne"},
			{"11020", "sehr viel Sonne"},
			{"13020", "wenig Sonne"},
			{"61020", "kaum Sonne"},
			{"98020", "enorm viel Sonne"}
	};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("PLZ eingeben: ");
		int input = scan.nextInt();

		while(input != 0) {
			System.out.println("Sonne? " + holeSonnenStunden(input));
			System.out.println("PLZ eingeben: ");
			input = scan.nextInt();
		}
	}

	private static String holeSonnenStunden(int input) {

		int firstValue = Integer.parseInt(array[0][0]);
		int lastValue = Integer.parseInt(array[array.length-1][0]);
		while(input > lastValue) {
			input--;
		}
		if(input < firstValue) {
			return Integer.toString(-1);
		}

		int finalInput = input;
		Optional<String> result = IntStream.range(0, array.length)
				.filter(i -> Integer.parseInt(array[i][0]) == finalInput)
				.mapToObj(i -> array[i][1])
				.findFirst();
		if(result.isPresent()) {
			return result.get() + " in PLZ: " + input;
		} else {
			return String.valueOf(-1);
		}
	}
}