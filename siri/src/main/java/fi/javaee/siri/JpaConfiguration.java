package fi.javaee.siri;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.hibernate.dialect.MySQL5Dialect;

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

/* Spring 4 versiossa kaikki konfiguraatiot voidaan JPA:lle tehdä Javalla - koodilla ja
 * annotaatioilla ilman yhtään riviä XML:ää. Tässä esimerkissä on strategiaksi valittu
 * Javan käyttö myös konfiguraatioiden luomiseen, sillä tällä tavalla on helpompi löytää
 * virheitä konfiguraatioista, kuin jos ne olisivat erillisessä XML-tiedostossa!
 * 
 * Tässä luokassa on kaikki konfiguraatiot hibernatesta MySQL:ään
 * tehty käyttäen Javaa.
 * 
 * Alla hyvä tutorial, jota käytetty luokan tekemisessä pohjana: 
 * http://www.baeldung.com/2011/12/13/the-persistence-layer-with-spring-3-1-and-jpa/
 */

@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.getDataSource());
		// haetaan luokkia ao. paketin alta
		em.setPackagesToScan(new String[] { "fi.javaee.siri"});

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
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
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

	// Palauttaa ohjelmallisesti DataSourcen metodissa annetun konfiguraation perusteella
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jee");
		dataSource.setUsername("root");
		dataSource.setPassword("root66");

		return dataSource;
	}

}
