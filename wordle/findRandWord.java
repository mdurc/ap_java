import java.util.*;

class findRandWord {
	public String answer;

	public String findRandAns(HashSet<String> answer) {
		String[] arr = answer.toArray(new String[answer.size()]);

		Random rndm = new Random();

		int rndmNumber = rndm.nextInt(answer.size());

		this.answer = arr[rndmNumber];
		return this.answer;
	}
}