import dao.mySql.AdminDao;
import dao.mySql.CustomerDao;
import dao.mySql.RoutesDao;
import domain.Route;
import services.EnterService;
import services.CustomerService;
import services.AdminService;
import services.Service;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String type = "";
        EnterService.hello();

        while (!EnterService.scanner.hasNext("[1-2]")) {
            EnterService.noValid();
            Service.scanner.next();
        }
        AdminService.adminVerif();
        CustomerService.userVerif();

        if(EnterService.getType().equals("admin"))
        {
            System.out.println("Если вы хотите получить полный список пользователей, то введите команду read");
            System.out.println("Если вы хотите удалить пользователя из списка пользователей, то введите команду delete");
            Service.scanner.next();

                if(EnterService.scanner.hasNext("delete"))
                {
                    System.out.println("Вы выбрали delete пользователя");
                    AdminService.deleteCustomer();
                    AdminDao adminDao = new AdminDao();
                    adminDao.delete(AdminService.custDel.fullName());
                    System.out.println("Пользователь " + AdminService.custDel.fullName + " удалён(а)");
                }

                if(EnterService.scanner.hasNext("read"))
                {
                    System.out.println("Вы выбрали read всех пользователей");
                    AdminDao adminDao = new AdminDao();
                    adminDao.readAllCustomers();
                    System.out.println(adminDao.resultStr);
                }

        }

        if(EnterService.getType().equals("customer")) {
            System.out.println("Если вы новый пользователь введите 1");
            System.out.println("Если вы уже есть в системе введите 2");
            Service.scanner.next();

            while (!EnterService.scanner.hasNext("[1-2]"))
            {
                EnterService.noValid();
                Service.scanner.next();
            }

            if(Service.scanner.hasNext("1"))
            {
                CustomerService.createCustomer();
                CustomerDao customerDao = new CustomerDao();
                customerDao.create(CustomerService.custEmpty.fullName,
                        CustomerService.custEmpty.getPassport(),
                        CustomerService.custEmpty.getPhoneNumber());
            }

            if(Service.scanner.hasNext("2"))
            {
                System.out.println("Доступные направления и кол-во свободных билетов. Успейте забронировать!!!");
                RoutesDao routesDao = new RoutesDao();
                routesDao.readAllRoutes();
                System.out.println(routesDao.result);
            }

            System.out.println("Введите номер маршрута, на который вы хотите приобрести билет");
            Service.scanner.nextInt();
            int numbRout = Service.scanner.nextInt();
            while (numbRout>RoutesDao.maxNumberRoute)
            {
                System.out.println("Вы ввели номер маршрута, которого нет");
                Service.scanner.nextInt();
            }
            Route.setNumberRout(numbRout);
            RoutesDao routesDao = new RoutesDao();
            routesDao.reserveTicket(Route.getNumberRout());
            System.out.println("Спасибо, мы поставили для вас в резерв билет на 15 мин. Просьба оплатить на сайте, в противном случае резерв будет снят.");
        }

    }
}




