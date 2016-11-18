package com.sites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration //I wasted so much time until i found this @ least 2 hours
public class App 
{
    public static void main( String[] args )
    {
    	//app entry point
        SpringApplication.run(App.class, args);
    }
}
