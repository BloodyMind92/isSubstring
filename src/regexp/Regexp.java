package regexp;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Regexp {

	private static boolean isSubstring;
	private static int countSubstr = 0;
	private static int countList = 0;

	public static void main(String[] args) {

		readString();

		if (isSubstring) {
			System.out.println("Second string is substring first");
		} else {
			System.out.println("Second string isn't substring first");
		}

	}

	private static void readString() {

		String string1;
		String string2;
		Scanner reader = new Scanner(System.in);

		System.out.println("Hi, can you enter first string?");
		string1 = reader.nextLine();

		System.out.println("Enter second string: ");
		string2 = reader.nextLine();

		if (string1.isEmpty() || string2.isEmpty()) {
			System.out.println("Error: at least one string is empty");
			readString();
		}

		if (string2.length() > string1.length()) {
			System.out.println("Error: second string is longer than first");
			readString();
		}

		Split split = new Split();

		List<String> substings = split.split(string2);

		checkSubstring(string1, substings);

	}

	private static void checkSubstring(String string1, List<String> substrings) {

		try {

			List<Character> str1List = string1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

			str1List.forEach(s -> {

				if (countList < substrings.size()) {

					String string2 = substrings.get(countList);

					if (countSubstr < string2.length()) {

						if (s.equals(string2.charAt(countSubstr))) {
							countSubstr++;

							if (countSubstr == string2.length()) {
								isSubstring = true;
							}

						} else {
							countSubstr = 0;
							isSubstring = false;
						}
					} else {
						countList++;
						countSubstr = 0;
					}
				}

			});

		} catch (NullPointerException e) {
			throw new RuntimeException("At least one string is is null");
		}

	}

}
