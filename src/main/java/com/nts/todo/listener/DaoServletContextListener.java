package com.nts.todo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nts.todo.dao.TodoDao;

public class DaoServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		TodoDao todoDao = new TodoDao();
		
		servletContext.setAttribute("dao", todoDao);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
