package com.nts.todo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nts.todo.dao.TodoDao;

public class DaoServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();

		try {
			String driver = ((ServletContext) event).getInitParameter("jdbcDriver");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
