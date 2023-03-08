import java.util.Scanner;

public class Main {
	static String[][] array = new String[5][2];

	public static void main(String[] args) {
		array[0][0] = "11020";
		array[1][0] = "12002";
		array[2][0] = "13003";
		array[3][0] = "14004";
		array[4][0] = "15005";
		array[0][1] = "viel Sonne";
		array[1][1] = "nicht so viel sonne";
		array[3][1] = "so viel sonne";
		array[4][1] = "kaum sonne";

		Scanner scan = new Scanner(System.in);
		System.out.println("PLZ eingeben: ");
		int input = scan.nextInt();

		while (input != 0) {
			System.out.println("Sonne? " + holeSonnenStunden(input));
			System.out.println("PLZ eingeben: ");
			input = scan.nextInt();
		}
	}

	private static String holeSonnenStunden(int input) {
		if (input < Integer.parseInt(array[0][0]))
			return Integer.toString(-1);

		int pos = 0;
		boolean gefunden = false;
		while (!gefunden && pos < array.length - 1) {
			if (Integer.parseInt(array[pos][0]) == input) {
				gefunden = true;
			} else {
				pos++;
			}
		}
		if (!gefunden) {
			input--;
			holeSonnenStunden(input);
		}

		return array[pos][1];
	}
}