package dev.fringe.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan(basePackages = "dev.fringe.persistence")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan( basePackages ="dev.fringe.service")
public class MapperConfig {

    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource d) throws Exception {
        MybatisSqlSessionFactoryBean s = new MybatisSqlSessionFactoryBean();
        s.setDataSource(d);
        s.setTypeAliasesPackage("dev.fringe.entity");
        return s.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory s) {
        return new SqlSessionTemplate(s);
    }
}
