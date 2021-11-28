package dev.fringe.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Bean
	LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") DataSource d) {
		LocalSessionFactoryBean l = new LocalSessionFactoryBean();
		l.setDataSource(d);
		l.setPackagesToScan("dev.fringe.model");
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		l.setHibernateProperties(p);
		return l;
	}
	
	@Bean(name = "transactionManager")
	@Autowired
	HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager t = new HibernateTransactionManager();
		t.setSessionFactory(s);
		return t;
	}
}
