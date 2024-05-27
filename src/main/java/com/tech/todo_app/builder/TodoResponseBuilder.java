package com.tech.todo_app.builder;

import com.tech.todo_app.dto.TodoResponse;
import com.tech.todo_app.entity.Todo;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Component
public class TodoResponseBuilder {
    public TodoResponse buildTodoResponseFromTodo(Todo todo) {
        TodoResponse todoResponse = TodoResponse.builder()
                .todoId(todo.getTodoId())
                .todo(todo.getTodo())
                .name(todo.getName())
                .targetDate(todo.getTargetDate())
                .status(todo.getStatus())
                .build();
        return todoResponse;
    }
}
