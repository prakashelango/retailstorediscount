package com.retailstore.retailsales.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by satish on 03/04/19.
 */


@Configuration
@EnableJpaRepositories(basePackages = "com.retailstore.retailsales.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "com.retailstore.retailsales.model")
public class AppConfiguration {




}
