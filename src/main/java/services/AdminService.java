package services;

import domain.Admin;
import domain.Customer;

public class AdminService extends Service {
    public static Customer custDel;

    public static void adminVerif(){

        if (scanner.hasNext("1")) {
            System.out.println("Введите login");
            scanner.next();
            while (!scanner.hasNext(Admin.getName())) {
                EnterService.noValid();
                System.out.println("Введите login");
                scanner.next();
            }
            System.out.println("Введите password");
            scanner.next();

            while (!scanner.hasNext(Admin.getPass())) {
                EnterService.noValid();
                System.out.println("Введите password");
                scanner.next();
            }

            System.out.println("Добро пожаловать admin");
            Service.setType("admin");
        }
    }
    public static void deleteCustomer()
    {
            System.out.println("Введите ФИО пользователя, которого вы хотите удалить из базы");
            custDel = new Customer();
            System.out.println("Введите Фамилию пользователя");
            custDel.setLastName(EnterService.scanner.next().trim());
            custDel.setLastName(EnterService.scanner.next().trim());
            System.out.println("Введите Имя пользователя");
            custDel.setFirstName(EnterService.scanner.next().trim());
            System.out.println("Введите Отчество пользователя");
            custDel.setMiddleName(EnterService.scanner.next().trim());
            custDel.fullName();
    }

    public static void readAllCustomers()
    {

    }

}
