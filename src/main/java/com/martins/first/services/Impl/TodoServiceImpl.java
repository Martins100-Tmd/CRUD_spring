package com.martins.first.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martins.first.dto.TodoDto;
import com.martins.first.entity.Todo;
import com.martins.first.error.ResourceNotFoundException;
import com.martins.first.mapper.TodoMapper;
import com.martins.first.repository.TodoRepository;
import com.martins.first.services.TodoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto createTodo(TodoDto dto) {
        Todo todo = TodoMapper.mapTodo(dto);
        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.mapTodoDto(savedTodo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream().map(TodoMapper::mapTodoDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto findTodoById(Integer id) {
        Todo foundTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", String.valueOf(id)));
        return TodoMapper.mapTodoDto(foundTodo);
    }

    @Override
    public TodoDto updateTodo(Integer id, String data) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", String.valueOf(id)));
        findTodo.setData(data);
        todoRepository.save(findTodo);
        return TodoMapper.mapTodoDto(findTodo);
    }

    @Override
    public String deleteTodo(Integer id) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", String.valueOf(id)));
        todoRepository.deleteById(id);
        return findTodo.getId().toString();
    }
}