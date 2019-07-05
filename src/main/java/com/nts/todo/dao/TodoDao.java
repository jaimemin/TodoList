package com.nts.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nts.todo.dto.Todo;

public class TodoDao {

	private static String DATABASE_URL = "jdbc:mysql://localhost/connectdb?useUnicode=true&characterEncoding=utf8";
	private static String DATABASE_ID = "connectuser";
	private static String DATABASE_PASSWORD = "connectuser123!@#";

	public int addTodo(Todo todo) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo(title, name, sequence) VALUES (?, ?, ?)";

		try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_ID, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2,  todo.getName());
			preparedStatement.setInt(3,  todo.getSequence());
			insertCount = preparedStatement.executeUpdate();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return insertCount;
	}
	
	public List<Todo> getTodos(){
		List<Todo> todoList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT title, regdate, name, sequence, type, id FROM todo ORDER BY DESC";
		
		try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_ID, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				while(resultSet.next()) {
					Todo todo = new Todo();
					todo.setTitle(resultSet.getString(1));
					todo.setRegisteredDate(resultSet.getString(2));
					todo.setName(resultSet.getString(3));
					todo.setSequence(resultSet.getInt(4));
					todo.setType(resultSet.getString(5));
					todo.setId(resultSet.getLong(6));
					todoList.add(todo);
				}
			}catch(Exception exception) {
				exception.printStackTrace();
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return todoList;
	}
	
	public int updateTodo(Todo todo) {
		int updateCount = 0;
		
		
		return updateCount;
	}
}
