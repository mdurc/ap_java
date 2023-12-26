import java.util.*;
import java.io.*;

class convert {
	public HashSet<String> accept;
	public HashSet<String> answer;

	public void readText() {
		HashSet<String> accept = new HashSet<String>();
		try {
			Scanner scan = new Scanner(new File("AcceptedInputs.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				accept.add(line);
			}
			this.accept = accept;
		} catch (FileNotFoundException e) {
		}

		// again for answers
		HashSet<String> answer = new HashSet<String>();
		try {
			Scanner scan2 = new Scanner(new File("Answers.txt"));
			while (scan2.hasNextLine()) {
				String line2 = scan2.nextLine();
				answer.add(line2);
			}
			this.answer = answer;
		} catch (FileNotFoundException e) {
		}
	}
}