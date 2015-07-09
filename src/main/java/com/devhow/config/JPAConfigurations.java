package com.devhow.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static com.devhow.constants.ConfigConstants.* ;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={PACKAGE_REPO})
@ComponentScan(PACKAGE_SERVICE)
@PropertySource(value = "classpath:"+PROPERTIES_FILE)
public class JPAConfigurations {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSrc = new DriverManagerDataSource();
		dataSrc.setDriverClassName(env.getProperty(DRIVER_CLASS));
		dataSrc.setPassword(env.getProperty(DB_PWD));
		dataSrc.setUrl(env.getProperty(DB_URL));
		dataSrc.setUsername(env.getProperty(DATABASE_USER));
		return dataSrc;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] {PACKAGE_REPO, PACKAGE_MODEL });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setShowSql(true);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		Properties jpaProperties = new Properties();
		setJpaPropertiesValues(jpaProperties);
		factoryBean.setJpaProperties(jpaProperties);
		return factoryBean;
	}

	private void setJpaPropertiesValues(Properties jpaProperties) {
		jpaProperties.put(HIBERNATE_DIALECT,env.getProperty(HIBERNATE_DIALECT));
		jpaProperties.put(HIBERNATE_DDL,env.getProperty(HIBERNATE_DDL));
		jpaProperties.put(HIBERNATE_SHOW_SQL,env.getProperty(HIBERNATE_SHOW_SQL));
		jpaProperties.put(HIBERNATE_AUTOCOMMIT,	env.getProperty(HIBERNATE_AUTOCOMMIT));
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			LocalContainerEntityManagerFactoryBean emf) {
		EntityManagerFactory factory = entityManagerFactoryBean().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DozerBeanMapper getMapper() {
		return new DozerBeanMapper();
	}

}
