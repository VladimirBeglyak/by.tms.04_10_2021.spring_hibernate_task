package by.beglyak.runner;

import by.beglyak.config.MyConfig;
import by.beglyak.dao.BaseDao;
import by.beglyak.entity.Cinema;
import by.beglyak.entity.Film;
import by.beglyak.service.ServiceDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }


        ServiceDao cinemaService = context.getBean("cinemaService", ServiceDao.class);

        Film film = new Film("Superman","awdqwdwe",LocalDateTime.now(),BigDecimal.valueOf(100));
        Film film1 = new Film("sefwsef","awdqwdwe",LocalDateTime.now(),BigDecimal.valueOf(80));

        Cinema cinema = new Cinema("Titan", "Dzerginskogo 111");
        cinema.addFilmsToCinema(film);
        cinema.addFilmsToCinema(film1);

//        cinemaService.save(cinema);
        cinemaService.delete(1l);




        context.close();

    }
}
