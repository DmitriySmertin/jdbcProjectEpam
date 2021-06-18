package services;

import domain.Customer;

public class CustomerService extends Service {
    public static Customer custEmpty;

    public static void userVerif() {
        if (scanner.hasNext("2")) {
            System.out.println("Добро пожаловать пользователь");
            CustomerService.setType("customer");
        }
    }

    public static void createCustomer()
    {
        custEmpty = new Customer();
        custEmpty.setLastName(EnterService.scanner.next().trim());
        System.out.println("Введите вашу Фамилию");
        custEmpty.setLastName(EnterService.scanner.next().trim());
        System.out.println("Введите вашу Имя");
        custEmpty.setFirstName(EnterService.scanner.next().trim());
        System.out.println("Введите вашу Отчество");
        custEmpty.setMiddleName(EnterService.scanner.next().trim());
        System.out.println("Введите вашу серию и номер паспорта");
        custEmpty.setPassport(EnterService.scanner.next().replaceAll(" ", ""));
        System.out.println("Введите ваш номер телефона в формате 89xxxxxxxxx");
        custEmpty.setPhoneNumber(EnterService.scanner.next().trim());
        custEmpty.fullName();
    }
}


