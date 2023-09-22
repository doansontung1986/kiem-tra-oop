package utilities;

import java.util.Scanner;

public class CheckValidInput {

    public static boolean isValidNumeric(String numberStr) {
        if (numberStr == null) {
            return false;
        }

        try {
            Double.parseDouble(numberStr);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static int inputValidNumber() {
        String numberStr;
        do {
            numberStr = new Scanner(System.in).nextLine();

            if (!isValidNumeric(numberStr)) {
                PrintMessage.printErrorMessage();
            }

        } while (!isValidNumeric(numberStr));

        return (int) Double.parseDouble(numberStr);
    }

}
