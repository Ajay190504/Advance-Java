package com.qualifierautowiring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.qualifierDemo")
public class AppConfig {

}