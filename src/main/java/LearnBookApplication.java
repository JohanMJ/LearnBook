

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;




@EnableJpaRepositories(basePackages="com.br.learnbook.repository")
@SpringBootApplication
public class LearnBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnBookApplication.class, args);
	}
	
	@Bean
	@ConfigurationProperties(prefix="datasource.main")
	public DataSource siteDataSourceBean(){
		return DataSourceBuilder.create()
								.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean 
		   siteEntityManagerFactoryBean(EntityManagerFactoryBuilder 
				   						builder){
		return builder.dataSource(siteDataSourceBean())
					  .packages("com.br.learnbook.models")
					  .persistenceUnit("LearnBookPU")
					  .build();
	}
	

	
}
