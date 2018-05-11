package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.config.AccessFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MicroserviceZuulApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
//  @Bean
//  public AccessFilter access() {
//	  return new AccessFilter();
//  }
  

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceZuulApplication.class, args);
  }
}
