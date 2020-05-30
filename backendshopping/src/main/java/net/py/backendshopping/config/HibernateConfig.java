package net.py.backendshopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.py.backendshopping.dto" })
@EnableTransactionManagement
//@PropertySource("classpath:connection.properties")
public class HibernateConfig {
	// @Value("${jdbc.url}")
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	// @Value("${jdbc.driver}")
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	// @Value("${jdbc.dialect}")
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	// @Value("${jdbc.username}")
	private final static String DATABASE_USERNAME = "sa";
	// @Value("${jdbc.password}")
	private final static String DATABASE_PASSWORD = "";

	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.py.backendshopping.dto");

		return builder.buildSessionFactory();

	}

	// Retorno de propiedades de hibernate
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		// properties.put("hibernate.hbm2ddl.auto", "create");

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
