package com.tech.todo_app.service;

import com.tech.todo_app.dto.TodoRequest;
import com.tech.todo_app.dto.TodoResponse;

import java.util.List;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
public interface ITodoService {
    TodoResponse addTodo(TodoRequest todoRequest);
    TodoResponse updateTodo(int todoId, String name, TodoRequest todoRequest);

    List<TodoResponse> getAllTodos();
    List<TodoResponse> getTodosByName(String name);
    TodoResponse getTodoById(Integer todoId);
    void deleteTodo(int todoId);
}
