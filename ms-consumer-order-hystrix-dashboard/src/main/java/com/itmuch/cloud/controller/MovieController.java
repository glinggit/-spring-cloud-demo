package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/movie-hystrix-dashboard/{id}")
  @HystrixCommand(fallbackMethod="failBack")
  public User findById(@PathVariable Long id) {
	  System.out.println("success:------------------------------");
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }

  public User failBack(Long id) {
	  User user = new User();
	  user.setId(0L);
	  System.out.println("error:------------------------------");
	  return user;	  
  }
}
