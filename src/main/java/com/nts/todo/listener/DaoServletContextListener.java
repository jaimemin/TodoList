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
			String driver = context.getInitParameter("jdbcDriver");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("JDBC 드라이버가 존재하지 않습니다.", e);
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
