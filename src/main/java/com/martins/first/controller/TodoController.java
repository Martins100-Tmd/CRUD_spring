package com.martins.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.martins.first.dto.TodoDto;
import com.martins.first.services.TodoService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todo) {
        TodoDto createResponse = todoService.createTodo(todo);
        return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findTodoById(@PathVariable Integer id) {
        TodoDto getTodoById = todoService.findTodoById(id);
        return ResponseEntity.ok(getTodoById);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto body, @PathVariable Integer id) {
        TodoDto updatedTodo = todoService.updateTodo(id, body.data());
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        String todoId = todoService.deleteTodo(id);
        return ResponseEntity.ok(todoId);
    }

}
