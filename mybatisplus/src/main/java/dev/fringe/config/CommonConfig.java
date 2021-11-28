package dev.fringe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan( basePackages ="dev.fringe.service")
public class CommonConfig {

}
