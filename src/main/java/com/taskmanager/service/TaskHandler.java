package com.taskmanager.service;

import java.util.List;

import com.taskmanager.entity.Task;
import com.taskmanager.pojo.UserRequest;

public interface TaskHandler {

	/***
	 * @param task body it creates the new task
	 */
	public void createTask(UserRequest requestBody);

	/***
	 * @param task body it updates the existing task
	 */
	public void updateTask(UserRequest requestBody);

	/***
	 * for finding the existing tasks based on task id
	 * 
	 * @param id
	 */
	public List<Task> findTask(String priority);

	/***
	 * get all Task
	 * 
	 * @return
	 */
	public List<Task> getAllTask();

	/***
	 * get task before a particular date
	 * 
	 * @param date
	 * @return
	 */
	public List<Task> getTaskOfTwoDays(String date);

}
