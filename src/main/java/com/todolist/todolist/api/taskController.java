package com.todolist.todolist.api;

import com.todolist.todolist.domain.dto.TaskDTO;
import com.todolist.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class taskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable final Long id){
        return ResponseEntity.ok().body(taskService.findTask(id));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.save(taskDTO));
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO, @PathVariable final Long id){
        try {
            return ResponseEntity.ok().body(taskService.update(taskDTO, id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable final Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
