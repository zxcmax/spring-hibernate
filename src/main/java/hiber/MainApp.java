package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("audi", 4)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("bmw", 5)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("bmw", 7)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("audi", 4)));

        userService.listUsers().forEach(System.out::println);

        userService.getUsersByCar("audi", 4).forEach(System.out::println);

        context.close();
    }
}
