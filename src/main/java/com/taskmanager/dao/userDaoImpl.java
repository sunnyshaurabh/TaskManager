package com.taskmanager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taskmanager.entity.Task;
import com.taskmanager.util.SessionUtil;
/***
 * Dao layer to interact with the DB 
 * @author sunny
 *
 */
@Repository("userDao")
public class userDaoImpl implements userDao {
	/***
	 * it creates a new entry of task
	 */
	@Override
	public void insertIntoDb(Task task) {
		Session session = SessionUtil.getSession();
		session.beginTransaction();
		session.persist(task);
		session.getTransaction().commit();
		session.close();
	}
	/***
	 * update a current record 
	 */
	@Override
	public void updateIntoDb(Task task) {
		Session session = SessionUtil.getSession();
		session.beginTransaction();
		System.out.println("done");
		session.update(task);
		session.getTransaction().commit();
		session.close();
	}
	
	/***
	 * find task based on User id
	 * @return 
	 */
	@Override
	public List<Task> findTask(String priority) {
		Criteria c=  SessionUtil.getSession().createCriteria(Task.class)
					   .add(Restrictions.le("priority",priority)); 
		List<Task> taskReceived = (List<Task>) c.list(); 
		return taskReceived;
	}
	
	/***
	 * get all the tasks
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Task> getAllTask() {
		Criteria c=  SessionUtil.getSession().createCriteria(Task.class); 
		List<Task> taskReceived = (List<Task>) c.list(); 
		
		return taskReceived;
	}
	@Override
	public List<Task> getTaskOfTwoDays(String date,String nextDate) {
		Criteria c= SessionUtil.getSession().createCriteria(Task.class).add(Restrictions.and
				     (Restrictions.le("date",nextDate),Restrictions.ge("date",date))); 
		List<Task> taskReceived = c.list();
		return taskReceived;
	}
}
