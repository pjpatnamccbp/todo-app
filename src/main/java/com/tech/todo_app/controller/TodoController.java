package com.tech.todo_app.controller;

import com.tech.todo_app.dto.TodoRequest;
import com.tech.todo_app.dto.TodoResponse;
import com.tech.todo_app.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @PostMapping("/add")
    public ResponseEntity<TodoResponse> addTodo(@RequestBody TodoRequest todoRequest){
        return new ResponseEntity<>(todoService.addTodo(todoRequest),HttpStatus.CREATED);
    }
    @PutMapping("/update/{name}/{todoId}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable("name") String name,
                                                   @PathVariable("todoId") int todoId,
                                                   @RequestBody TodoRequest todoRequest){
        return new ResponseEntity<>(todoService.updateTodo(todoId,name,todoRequest),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }
    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable("todoId") int todoId){
        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }
    @GetMapping("/query")
    public ResponseEntity<List<TodoResponse>> getTodoByName(@RequestParam("name") String name){
        return new ResponseEntity<>(todoService.getTodosByName(name), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStatus> deleteTodo(@PathVariable("todoId") int todoId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
