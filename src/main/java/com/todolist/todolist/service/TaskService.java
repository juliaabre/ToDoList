package com.todolist.todolist.service;

import com.todolist.todolist.domain.Task;
import com.todolist.todolist.domain.dto.TaskDTO;
import com.todolist.todolist.infra.mapper.TaskMapper;
import com.todolist.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDTO findTask(final Long id){
        return taskMapper.toTaskDTO(taskRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public TaskDTO save(final TaskDTO taskDTO){
        final Task task = taskMapper.toTask(taskDTO);
        return taskMapper.toTaskDTO(taskRepository.save(task));
    }

    public TaskDTO update(final TaskDTO taskDTO, final Long id) throws Exception {
        final Optional<TaskDTO> dto = Optional.ofNullable(findTask(id));

        if(dto.isPresent()){
            final Task task = taskMapper.toTask(dto.get());

            task.setId(id);
            task.setTitle(task.getTitle());
            task.setDescription(task.getDescription());
            task.setDate(LocalDate.now());
            task.setStatus(task.getStatus());

            return taskMapper.toTaskDTO(task);
        }
        throw new Exception("Error");
    }

    public void delete(final Long id){
        taskRepository.deleteById(id);
    }
}
