import java.util.*;

class Main {

	

	public static void main(String[] args) {


		
		convert data = new convert();
		data.readText();
		print game = new print();
		findRandWord randomanswer = new findRandWord();
		boolean cont = true;
		ArrayList<String> guesses = new ArrayList<>();
		ArrayList<char[]> success = new ArrayList<>();

		String answer = randomanswer.findRandAns(data.answer);
		//System.out.println("\n\n*for testing* the answer is: " + answer);
		String word = "";
		do {
			label: {
				System.out.println("\nWord:");
				Scanner scan = new Scanner(System.in);
				word = scan.nextLine().toLowerCase();

				game.Printcheck(word, data.accept, data.answer, answer);
				if (game.check(word, data.accept, data.answer, answer)) {
					break label;
				} else {

				}
				char[] good = game.success(word, answer);
				print.known = print.contains(word, answer, print.known);
				game.printContains();

				success.add(good);
				if (success.size() > 5) {
					System.out.println("\nYOU LOSE");
					System.out.println("\n\nAnswer was : " + answer);
					System.exit(0);
				}
				game.printSuccess(success);

			}
		} while (cont == true);

	}
}