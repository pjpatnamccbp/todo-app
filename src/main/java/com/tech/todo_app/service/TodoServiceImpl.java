package com.tech.todo_app.service;

import com.tech.todo_app.builder.TodoRequestBuilder;
import com.tech.todo_app.builder.TodoResponseBuilder;
import com.tech.todo_app.dao.TodoJpaRepository;
import com.tech.todo_app.dto.TodoRequest;
import com.tech.todo_app.dto.TodoResponse;
import com.tech.todo_app.entity.Todo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Service
@AllArgsConstructor
public class TodoServiceImpl implements ITodoService{
    private TodoJpaRepository todoJpaRepository;
    private TodoRequestBuilder todoRequestBuilder;
    private TodoResponseBuilder todoResponseBuilder;

    @Override
    public TodoResponse addTodo(TodoRequest todoRequest) {
        Todo todo = todoRequestBuilder.buildTodoFromTodoRequest(todoRequest);
        Todo savedTodo = todoJpaRepository.save(todo);
        return todoResponseBuilder.buildTodoResponseFromTodo(todo);
    }

    @Override
    public TodoResponse updateTodo(int todoId, String name,TodoRequest todoRequest) {

        Todo savedTodo = todoJpaRepository.findById(todoId).get();
        savedTodo.setTodo(todoRequest.getTodo());
        savedTodo.setTargetDate(todoRequest.getTargetDate());
        savedTodo.setStatus("completed");
        todoJpaRepository.save(savedTodo);
        return todoResponseBuilder.buildTodoResponseFromTodo(savedTodo);
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        return todoJpaRepository.findAll().stream().map(todoResponseBuilder::buildTodoResponseFromTodo)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoResponse> getTodosByName(String name) {
        List<Todo> todosByName = todoJpaRepository.findAllByName(name);

        return todosByName.stream().map(todoResponseBuilder::buildTodoResponseFromTodo)
                .collect(Collectors.toList());
    }

    @Override
    public TodoResponse getTodoById(Integer todoId) {
        Todo todo = todoJpaRepository.findById(todoId).get();
        return todoResponseBuilder.buildTodoResponseFromTodo(todo);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoJpaRepository.deleteById(todoId);
        //Todo todo = todoJpaRepository.findById(todoId).get();

    }
}
