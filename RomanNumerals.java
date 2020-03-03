import java.util.Scanner;

public class RomanNumerals {

    public static void main(String args[]) {

        RomanNumeralsConverter myConverter = new RomanNumeralsConverter();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter R to convert romans to integer or choose I to convert integer to romans. Enter Q to quit.");
        String option = myScanner.nextLine();

        while (!option.equals("Q")) {

            if (option.equals("R")) {
                System.out.print("Enter Roman: ");
                String romanToConvert = myScanner.nextLine();
                System.out.println("Integer: " + myConverter.convertRomanToInt(romanToConvert) + "\n");
            } else {
                System.out.print("Enter Integer: ");
                int intToConvert = Integer.parseInt(myScanner.nextLine());

                try {
                    System.out.println("Roman: " + myConverter.convertIntToRoman(intToConvert) + "\n");
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

            }

            System.out.println("Enter R to convert romans to integer or choose I to convert integer to romans. Enter Q to quit.");
            option = myScanner.nextLine();
        }

    }
}
