package fi.javaee.siri.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fi.javaee.siri.web.SpringServletConfiguration;

@Configuration
@EnableTransactionManagement
// @EnableAutoConfiguration
@ComponentScan(basePackages = { "fi.javaee.siri.user", "fi.javaee.siri.asiakas", "fi.javaee.siri.yritys",
		"fi.javaee.siri.config", "siri.javaee.siri.controller" })
public class SiriTestConfiguration {

}
