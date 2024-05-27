package com.tech.todo_app.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Data
@Builder
public class TodoRequest {
    private String todo;
    private String name;
    private String targetDate;
}
