package com.martins.first.mapper;

import com.martins.first.dto.TodoDto;
import com.martins.first.entity.Todo;

public class TodoMapper {
    public static TodoDto mapTodoDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getData());
    }

    public static Todo mapTodo(TodoDto dto) {
        return new Todo(dto.id(),
                dto.data());
    }
}