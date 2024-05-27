package com.tech.todo_app.builder;

import com.tech.todo_app.dto.TodoRequest;
import com.tech.todo_app.entity.Todo;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Component
public class TodoRequestBuilder {
    public Todo buildTodoFromTodoRequest(TodoRequest todoRequest) {
        Todo todo = Todo.builder()
                .todo(todoRequest.getTodo())
                .name(todoRequest.getName())
                .targetDate(todoRequest.getTargetDate())
                .status("accepted")
                .build();
        return todo;

    }
}
