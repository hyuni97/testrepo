package com.my.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final List<TodoDto> todoList = new ArrayList<>();

    public List<TodoDto> readAll(){
        return todoList;
    }
}
