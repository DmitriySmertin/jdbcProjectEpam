package services;

import java.util.Scanner;

public class Service {


    private static String type = "";

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Service.type = type;
    }

    public static Scanner scanner = new Scanner(System.in);
}
