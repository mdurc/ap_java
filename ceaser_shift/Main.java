import java.util.*;

class Main {
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    String again = "yes";
    do {

      System.out.println("1. Send message\n2. Recieve message\nType in number 1 or 2");
      if (scan.nextInt() == 1) {
        scan.nextLine();
        System.out.println("Input: ");

        String input = scan.nextLine().toUpperCase();
        System.out.println("How many shifts: ");

        int shifts = scan.nextInt();// rotate number

        sendMessage(input, shifts);

      } else {
        scan.nextLine();
        System.out.println("Input: ");

        String codedInput = scan.nextLine().toUpperCase();
        System.out.println("How many shifts: ");
        int shifts = scan.nextInt();

        receiveMessage(codedInput, shifts);
      }
      scan.nextLine();
      System.out.println("Again? Yes or No");
      again = scan.nextLine();
    } while (again.toLowerCase().equals("yes"));

  }

  public static void sendMessage(String input, int shifts) {
    String codedInput = "";
    for (int i = 0; i < input.length(); i++) {// go through each value of the char array to change to the coded value
                                              // and then add it to the new codedInput string
      int characterValue = input.charAt(i);
      if (characterValue == 32) {// space
        codedInput += " ";// Using ascii values to change the value of a char.
        // search up ascii to find a table on images
      } else if (characterValue + shifts > 90) {
        int difference = characterValue + shifts - 90;
        characterValue = 64 + difference;
        codedInput += String.valueOf((char) (characterValue));
      } else {

        codedInput += String.valueOf((char) (characterValue + shifts));
      }

    }
    System.out.println(codedInput);
  }

  public static void receiveMessage(String input, int shifts) {
    String codedInput = "";
    for (int i = 0; i < input.length(); i++) {
      int characterValue = input.charAt(i);
      if (characterValue == 32) {
        codedInput += " ";
      } else if (characterValue - shifts < 65) {
        int difference = 65 - characterValue + shifts;
        characterValue = 91 - difference;
        codedInput += String.valueOf((char) (characterValue));
      } else {
        codedInput += String.valueOf((char) (characterValue - shifts));
      }

    }
    System.out.println(codedInput);
  }
}

// 65 = A
// c
// 90 = Z