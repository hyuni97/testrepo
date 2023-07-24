package com.my.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final List<TodoDto> todoList = new ArrayList<>();
    private long nextId = 1l;

    public List<TodoDto> readAll(){
        return todoList;
    }
    public void createToDo(String content){
        TodoDto newTodo = new TodoDto(nextId, content, false);
        nextId++;
        todoList.add(newTodo);
        System.out.println(todoList);
    }
    public TodoDto updateToDo(Long id) {
        return todoList
            .stream()
            .filter(todoDto -> todoDto.getId().equals(id))
            .peek(todoDto -> todoDto.setDone(!todoDto.getDone()))
            .findFirst()
            .orElse(null);
    }
    public boolean deleteToDo(Long id){
        OptionalInt idx = IntStream
            .range(0, todoList.size())
            .filter(i -> todoList.get(i).getId().equals(id))
            .findFirst();
        if(idx.isPresent()){
            todoList.remove(idx.getAsInt());
            return true;
        }
        return false;
    }
}
