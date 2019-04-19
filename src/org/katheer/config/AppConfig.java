package org.katheer.config;

import org.katheer.controller.StudentController;
import org.katheer.controller.StudentControllerImpl;
import org.katheer.dao.StudentDao;
import org.katheer.dao.StudentDaoImpl;
import org.katheer.service.StudentService;
import org.katheer.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("katheer");

        return dataSource;
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDaoImpl();
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public StudentController studentController() {
        return new StudentControllerImpl();
    }
}
