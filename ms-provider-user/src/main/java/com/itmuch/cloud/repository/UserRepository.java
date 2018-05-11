package com.itmuch.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//自定义sql查询
	@Query("select u from User u where u.name = ?1")
	User findByName(String name);

}
