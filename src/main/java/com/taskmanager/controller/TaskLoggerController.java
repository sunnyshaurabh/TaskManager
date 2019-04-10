package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entity.Task;
import com.taskmanager.pojo.UserRequest;
import com.taskmanager.service.TaskHandler;
/***
 * controller to handle task requests
 * @author sunny
 *
 */
@RestController
public class TaskLoggerController {

	@Autowired
	@Qualifier("taskHandler")
	private TaskHandler taskHandler;
	
	
	/***
	 * this controller is for saving user's data
	 * @param userRequestModel
	 * @throws Exception
	 */
	@PostMapping(value = "/createTask")
	public void postTaskDetails(@RequestBody UserRequest userRequestModel) throws Exception {
		taskHandler.createTask(userRequestModel);
	}
	
	
	/***
	 * this controller is for updating user info
	 * @param userRequestModelt
	 * @throws Exception
	 */
	@PostMapping(value = "/updateInfo")
	public void updateTaskDetails(@RequestBody UserRequest userRequestModelt) throws Exception {
		taskHandler.updateTask(userRequestModelt);
	}
	
	
	/***
	 * this controller is for finding task on priority
	 * @param t
	 * @return 
	 */
	@GetMapping(value = "/findTask/{priority}")
	public ResponseEntity<List<Task>> FindTaskByPriority(@PathVariable("priority") String priority)  {
		List<Task> task = taskHandler.findTask(priority);
		return ResponseEntity.ok().body(task);
	}
	
	
	/***
	 * this controller is to get all the task 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getAllTask")
	public ResponseEntity<List<Task>> getAllTask() throws Exception {
		List<Task> task = taskHandler.getAllTask();
		return ResponseEntity.ok().body(task);
	}
	
	
	/***
	 * this controller is to get task based on dates
	 * the tasks which will be under next two days will be fetched.
	 * @param s
	 * @return
	 */
	@GetMapping(value = "/getTaskBeforDate/{date}")
	public ResponseEntity<List<Task>> getTaskOfTwoDays(@PathVariable("date") String date) {
		List<Task> task =taskHandler.getTaskOfTwoDays(date);
		return ResponseEntity.ok().body(task);
	}
}