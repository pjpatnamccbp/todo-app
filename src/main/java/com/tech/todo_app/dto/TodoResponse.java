package com.tech.todo_app.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Data
@Builder
public class TodoResponse {
    private int todoId;
    private String name;
    private String todo;
    private String targetDate;
    private String status;
}
