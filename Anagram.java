/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String anagram = "";

		if (str1.length() != str2.length()) {
			return false;
		}
		// Checks if char is in both strings, appends it to a new one
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					anagram += str1.charAt(i);
					break;
				}
			}
		}

		if (anagram.length() == str1.length()) {
			return true;
		}
		return false;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String noSpecial = "";
		String newStr = "";

		// Checks for and removes special chars
		for (int i = 0; i < str.length(); i++) {
			if (!(((char) str.charAt(i) >= ' ' && (char) str.charAt(i) <= '/')
					|| ((char) str.charAt(i) >= ':' && (char) str.charAt(i) <= '@'))) {
				noSpecial += str.charAt(i);
			}
		}
		// Checks for and replaces upper case
		for (int i = 0; i < noSpecial.length(); i++) {
			if ((char) noSpecial.charAt(i) >= 'A' && (char) noSpecial.charAt(i) <= 'Z') {
				newStr += (char) (noSpecial.charAt(i) + 32);
			} else {
				newStr += noSpecial.charAt(i);
			}
		}
		return newStr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String randomAnagram = str;
		double randomShift = (Math.random() * str.length());

		// If the generated num is 0 redo
		while (randomShift == 0) {
			randomShift = (Math.random() * str.length());
		}

		// New string from the random number to the end, and from the start to the
		// random index
		randomAnagram = str.substring((int) randomShift, randomAnagram.length());
		randomAnagram += str.substring(0, (int) randomShift);

		return randomAnagram;
	}
}