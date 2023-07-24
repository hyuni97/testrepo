package com.my.todolist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TodoController {
  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping("/todo")
  public String todo(Model model) {
    List<TodoDto> todoDtoList = this.todoService.readAll();
    model.addAttribute("todoList", todoDtoList);
    return "todo";
  }

  @RequestMapping("/")
  public String home() {
    return "redirect:todo";
  }

  @PostMapping("/todo/create")
  public String create(
        @RequestParam("todo-desc") String content) {
      // 새로운 TODO를 생성하는 컨트롤러 메소드
      todoService.createToDo(content);
      return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/update")
    public String update(@PathVariable("id") Long id) {
      // TODO의 done 상태를 변경하는 메소드
      todoService.updateToDo(id);
      return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
      // TODO의 done 상태를 삭제하는 메소드
      todoService.deleteToDo(id);
      return "redirect:/todo";
    }
}