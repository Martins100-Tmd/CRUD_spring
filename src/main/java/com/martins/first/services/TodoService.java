package com.martins.first.services;

import java.util.List;

import com.martins.first.dto.TodoDto;

public interface TodoService {
    TodoDto createTodo(TodoDto todo);

    List<TodoDto> getAllTodos();

    TodoDto findTodoById(Integer id);

    TodoDto updateTodo(Integer id, String data);

    String deleteTodo(Integer id);

}
