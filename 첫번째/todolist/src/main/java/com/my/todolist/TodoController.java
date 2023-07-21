package com.my.todolist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo")
    public String todo(Model model) {
        List<TodoDto> todoDtoList = this.todoService.readAll();
        model.addAllAttributes(todoDtoList);
        return "todo";
    }

    @RequestMapping("/")
    public String home(){
        return "redirect:/todo";
    }
}
