package services;

import domain.Admin;

import java.util.Scanner;

public class EnterService extends Service {

    public static void noValid()
    {
        System.out.println("Невалидный ввод данных");
        System.out.println("Попробуйте ещё раз");
    }

    public static void hello()
    {
        System.out.println("Приветсвую в системе TicketRailRoadService");
        System.out.println("Если вы являетесь администратором, введите 1");
        System.out.println("Если вы являетесь клиентом введите 2");
    }


}
