package com.taskmanager.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.taskmanager.dao.userDao;
import com.taskmanager.entity.Task;
import com.taskmanager.exception.InvalidPrioritiesException;
import com.taskmanager.pojo.UserRequest;
import com.taskmanager.support.Priorities;


/***
 * service layer of the app to manage basic CURD operations
 * 
 * @author sunny
 *
 */
@Service("taskHandler")
public class TaskHandlerImpl implements TaskHandler {

	@Autowired
	@Qualifier("userDao")
	userDao userDao;

	@Override
	public void createTask(UserRequest requestBody) {
		Task task = new Task();
		task.setTaskNum(requestBody.getTaskid());
		task.setDate(requestBody.getDate());
		task.setLabel(requestBody.getLabel());
		task.setPriority(getPriority(requestBody));
		userDao.insertIntoDb(task);
	}

	@Override
	public void updateTask(UserRequest requestBody) {
		Task task = new Task();
		task.setTaskNum(requestBody.getTaskid());
		task.setDate(requestBody.getDate());
		task.setPriority(requestBody.getPriority());
		userDao.updateIntoDb(task);
	}

	@Override
	public List<Task> findTask(String priority) {
		return userDao.findTask(priority);
	}

	@Override
	public List<Task> getTaskOfTwoDays(String date) {
		return userDao.getTaskOfTwoDays(date,addTwoDay(date));
	}

	@Override
	public List<Task> getAllTask() {

		return userDao.getAllTask();
	}

	/***
	 * Method to set priority based with the help of enum for maintaining input
	 * standards
	 * 
	 * @param requestBody
	 * @return
	 */
	private String getPriority(UserRequest requestBody) {
		Priorities p;
		try {
			p = Priorities.valueOf(requestBody.getPriority());
		} catch (Exception e) {
			throw new InvalidPrioritiesException(
					"the priority entered was " + "out of scope please enter a valid priority");
		}
		switch (p) {
		case CRITICAL:
			return Priorities.CRITICAL.toString();
		case HIGH:
			return Priorities.HIGH.toString();
		default:
			return Priorities.MEDIUM.toString();
		}
	}

	 public static String addTwoDay(String date) {
		return LocalDate.parse(date).plusDays(2).toString();
	}

}
