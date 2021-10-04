package by.beglyak.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("by.beglyak")
//@EnableWebMvc
@EnableTransactionManagement
//@PropertySource("classpath:myapp.properties")
public class MyConfig {

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource =
                new ComboPooledDataSource();
        try{
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/spring_hiber_04_10_21?useSSL=false&amp;serverTimezone=UTC");
            dataSource.setUser("postgres");
            dataSource.setPassword("postgres");
        } catch (PropertyVetoException exception){
            exception.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory
                .setPackagesToScan("by.beglyak.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL10Dialect");
        hibernateProperties.setProperty("hibernate.show_sql","true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;

    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

//    @Bean
//    public ViewResolver viewResolver(){
//
//        InternalResourceViewResolver internalResourceViewResolver =
//                new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
//        internalResourceViewResolver.setSuffix(".jsp");
//
//        return internalResourceViewResolver;
//    }


}
