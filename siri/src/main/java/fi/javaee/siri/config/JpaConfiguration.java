package fi.javaee.siri.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.getDataSource());
		// haetaan luokkia ao. paketin alta
		// em.setPackagesToScan(new String[] { "fi.javaee.siri.controller",
		// "fi.javaee.siri.asiakas", "fi.javaee.siri.yritys" });
		em.setPackagesToScan(new String[] { "fi.javaee.siri" });

		// JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaVendorAdapter(this.jpaVendorAdapter());

		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	// Tarvitaan PersistenceExceptionTranslationPostProcessor beania varten
	@Bean
	public HibernateJpaDialect hibernateJpaDialect() {
		return new HibernateJpaDialect();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		// properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	// Palauttaa ohjelmallisesti DataSourcen metodissa annetun konfiguraation
	// perusteella
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/siridb");
		dataSource.setUsername("root");
		dataSource.setPassword("root66");

		return dataSource;
	}

}
