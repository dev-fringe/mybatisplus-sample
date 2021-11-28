package dev.fringe;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dev.fringe.config.DataSourceConfig;
import dev.fringe.config.MapperConfig;
import dev.fringe.persistence.MainModelMapper;

@Configuration
@Import(value = {MapperConfig.class, DataSourceConfig.class})
public class Main implements InitializingBean {

	@Autowired
	MainModelMapper mapper;

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(mapper.selectList(null));
	}
}