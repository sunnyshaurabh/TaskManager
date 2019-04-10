

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.taskmanager.service"})
@SpringBootApplication(scanBasePackages = { "com.taskmanager.service","com.taskmanager.controller","com.taskmanager.dao" })
public class TaskMan11Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskMan11Application.class, args);
	}

}
