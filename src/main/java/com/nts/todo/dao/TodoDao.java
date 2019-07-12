package com.nts.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nts.todo.dto.TodoDto;

public class TodoDao {
	private static String DATABASE_URL = "jdbc:mysql://10.113.116.52:13306/user11";
	private static String DATABASE_ID = "user11";
	private static String DATABASE_PASSWORD = "user11";

	public TodoDao() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	public int addTodo(TodoDto todo) throws SQLException {
		int insertCount;
		String sql = "INSERT INTO todo(title, name, sequence) VALUES (?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_ID, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2, todo.getName());
			preparedStatement.setInt(3, todo.getSequence());

			insertCount = preparedStatement.executeUpdate();
		}

		return insertCount;
	}

	private TodoDto getTodo(ResultSet resultSet) throws SQLException {
		TodoDto todo = new TodoDto();
		todo.setTitle(resultSet.getString(1));
		todo.setRegisteredDate(resultSet.getTimestamp(2));
		todo.setName(resultSet.getString(3));
		todo.setSequence(resultSet.getInt(4));
		todo.setType(resultSet.getString(5));
		todo.setId(resultSet.getLong(6));

		return todo;
	}

	public List<TodoDto> getTodos() throws SQLException {
		List<TodoDto> todoList = new ArrayList<>();
		String sql = "SELECT title, regdate, name, sequence, type, id FROM todo ORDER BY regdate DESC";

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_ID, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					todoList.add(getTodo(resultSet));
				}
			}
		}

		return todoList;
	}

	public int updateTodo(TodoDto todo) throws SQLException {
		int updateCount;
		String sql = "UPDATE todo SET type = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_ID, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, todo.getType());
			preparedStatement.setLong(2, todo.getId());

			updateCount = preparedStatement.executeUpdate();
		}

		return updateCount;
	}
}
