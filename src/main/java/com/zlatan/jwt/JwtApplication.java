package com.zlatan.jwt;

import com.zlatan.jwt.entity.Role;
import com.zlatan.jwt.entity.User;
import com.zlatan.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			userService.saveUser(new User(null,"John Wick","john","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Dominic Toretto","toretto","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jason Statham","jason","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"The Rock","rock","1234",new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("john","ROLE_ADMIN");

			userService.addRoleToUser("toretto","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("toretto","ROLE_ADMIN");

			userService.addRoleToUser("jason","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jason","ROLE_ADMIN");
			userService.addRoleToUser("jason","ROLE_MANAGER");

			userService.addRoleToUser("rock","ROLE_MANAGER");
			userService.addRoleToUser("rock","ROLE_ADMIN");

		};
	}
}
