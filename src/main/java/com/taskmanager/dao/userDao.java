package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.entity.Task;

public interface userDao {

	public void insertIntoDb(Task user);
	
	public void updateIntoDb(Task t);

	public List<Task> findTask(String priority);

	public List<Task> getAllTask();

	public List<Task> getTaskOfTwoDays(String date, String nextDate);
}
