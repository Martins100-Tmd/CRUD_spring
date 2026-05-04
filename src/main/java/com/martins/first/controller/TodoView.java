package com.martins.first.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martins.first.dto.TodoDto;
import com.martins.first.services.TodoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/api/todo/view")
public class TodoView {

    TodoService todoService;

    @GetMapping("/todopage")
    public String todoPage(Model model) {
        List<TodoDto> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "hello";
    }
}
