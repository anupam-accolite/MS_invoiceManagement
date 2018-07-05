/**
 * 
 */
package com.accolite.invoice_backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class containing all application configuration.
 * 
 * @author
 */
@Configuration
@ComponentScan(basePackageClasses = { com.accolite.invoice_backend.rest.PackageInfo.class, PackageInfo.class
         })
@EnableJpaRepositories(basePackageClasses = { com.accolite.invoice_backend.repository.PackageInfo.class })
@EntityScan(basePackageClasses = { com.accolite.invoice_backend.entity.PackageInfo.class })
@PropertySource("classpath:application.properties")
public class AppConfig {

}
