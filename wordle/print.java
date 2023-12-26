import java.util.*;

class print {
	public static ArrayList<Character> known = new ArrayList<>();

	public boolean check(String word, HashSet<String> accept, HashSet<String> answers, String answer) {
		if (!accept.contains(word) && !answers.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

	public void Printcheck(String word, HashSet<String> accept, HashSet<String> answers, String answer) {
		if (!accept.contains(word) && !answers.contains(word)) {
			System.out.println("Not word / More than 5 letters");

		} else if (word.equals(answer)) {
			System.out.println("\n\nYou Win");
			System.exit(0);
		} else {

		}
	}

	public char[] success(String word, String answer) {
		char[] save = new char[6];
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == answer.charAt(i)) {
				save[i] = answer.charAt(i);

			} else {
				save[i] = '❌';
			}
		}
		return save;
	}

	public void printSuccess(ArrayList<char[]> save) {

		System.out.println();
		for (int i = 0; i < save.size(); i++) {
			for (int k = 0; k < 5; k++) {
				System.out.print(save.get(i)[k] + " ");
			}
			System.out.println();
		}

		int amt = 6 - save.size();
		for (int p = 0; p < amt; p++) {
			System.out.println("_ _ _ _ _");
		}
	}

	public static ArrayList<Character> contains(String word, String answer, ArrayList<Character> chars) {
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				if (word.charAt(k) == answer.charAt(i) && !chars.contains(word.charAt(k)) && k == i) {

				} else if (word.charAt(k) == answer.charAt(i) && chars.contains(word.charAt(k)) && k == i) {
					print.removeContains(word.charAt(k));
				} else if (word.charAt(k) == answer.charAt(i) && !chars.contains(word.charAt(k))) {
					chars.add(word.charAt(k));
				}

			}
		}
		return chars;
	}

	public void printContains() {
		System.out.print("Contains: ");
		for (int i = 0; i < known.size(); i++) {
			System.out.print(known.get(i) + " ");
		}
	}

	public static void removeContains(Character letter) {
		for (int i = 0; i < print.known.size(); i++) {
			if (print.known.get(i) == letter) {
				print.known.remove(i);
			}
		}
	}
}