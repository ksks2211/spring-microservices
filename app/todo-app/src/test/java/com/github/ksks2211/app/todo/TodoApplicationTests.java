package com.github.ksks2211.app.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetTodos() {
        // Map<String, List<TodoDTO>>
        ResponseEntity<TodoListResponse> response = restTemplate.getForEntity("/todos", TodoListResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getTodos());
    }

    @Test
    void testCreateTodo(){
        var title = "Hello World";
        TodoCreateRequest reqBody = new TodoCreateRequest(title);
        ResponseEntity<TodoCreateSuccessResponse> response = restTemplate.postForEntity("/todos", reqBody, TodoCreateSuccessResponse.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
    }

}
