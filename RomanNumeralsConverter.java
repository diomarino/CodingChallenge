import java.security.InvalidParameterException;

public class RomanNumeralsConverter {

    private static int[] values;

    private static String[] romans;

    public RomanNumeralsConverter() {
        this.values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10,
        9, 5, 4, 1};

        this.romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L",
                "XL", "X", "IX", "V", "IV", "I"};
    }

    /**
     * Converts roman string into integer
     * @param roman
     * @return the value of the roman string
     */
    public int convertRomanToInt(String roman) {
        int result = 0;


        for (int i = 0; i < roman.length(); i++) {

            if (i < roman.length() - 1) {
                char leftChar = roman.charAt(i);
                char rightChar = roman.charAt(i + 1);
                int leftValue = values[getValuePositionInArray(leftChar)];
                int rightValue = values[getValuePositionInArray(rightChar)];

                if (leftValue < rightValue) {
                    result += rightValue - leftValue;
                    i++;

                } else {
                    result += leftValue;
                }

            } else {
                result += values[getValuePositionInArray(roman.charAt(i))];
            }
        }

        return result;
    }

    /**
     * Gets the position of the currChar in the romans array
     * @param currChar
     * @return
     */
    public int getValuePositionInArray(char currChar) {

        String stringChar = Character.toString(currChar);
        int position = -1;

        for (int i = 0; i < romans.length; i++) {
            if (stringChar.equals(romans[i])) {
                position = i;
            }
        }

        return position;
    }

    /**
     * Converts number to roman string
     * @param number
     * @return the roman interpretation of the number
     * @throws InvalidParameterException if number is 0
     */
    public String convertIntToRoman(int number) throws InvalidParameterException {

        if (number == 0) {
            throw new InvalidParameterException("Integer can't be zero");
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                builder.append(romans[i]);
            }
        }

        return builder.toString();
    }
}
