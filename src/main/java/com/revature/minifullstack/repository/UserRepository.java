package com.revature.minifullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.minifullstack.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value="SELECT * FROM USERS WHERE username= :username AND password = :password",
			   nativeQuery=true)
	    public User login(@Param("username") String userName, @Param("password") String password);

	
		

}
