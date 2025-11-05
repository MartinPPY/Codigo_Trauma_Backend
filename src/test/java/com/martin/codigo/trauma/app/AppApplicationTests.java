package com.martin.codigo.trauma.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.martin.codigo.trauma.app.controller.EmergencyController;
import com.martin.codigo.trauma.app.controller.UserController;
import com.martin.codigo.trauma.app.controller.UsersEmergenciesController;

//IMPORTAR ASSERTJ
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private UserController userController;
	@Autowired
	private EmergencyController emergencyController;
	@Autowired
	private UsersEmergenciesController usersEmergenciesController;

	@Test
	void contextLoads() {
		// verifica que el user controller no es nulo
		assertThat(userController).isNotNull();
		assertThat(emergencyController).isNotNull();
		assertThat(usersEmergenciesController).isNotNull();
	}

}
