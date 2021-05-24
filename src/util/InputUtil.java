package util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String title){
        System.out.print(title + " : ");
        String data = scanner.nextLine();

        return data;
    }

}
