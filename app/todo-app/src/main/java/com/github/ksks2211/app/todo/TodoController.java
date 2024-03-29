package com.github.ksks2211.app.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author rival
 * @since 2024-02-18
 */
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("")
    public TodoListResponse findAllTodos(){
        return todoService.getAllTodos();
    }


    @PostMapping("")
    public ResponseEntity<?> addTodo(@RequestBody TodoCreateRequest todoCreateForm){

        Long id = todoService.saveTodo(todoCreateForm);
        TodoCreateSuccessResponse body = new TodoCreateSuccessResponse();
        body.setId(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}
