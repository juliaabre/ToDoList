package com.todolist.todolist.infra.mapper;

import com.todolist.todolist.domain.Task;
import com.todolist.todolist.domain.dto.TaskDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", imports = UserUtils.class)
public interface TaskMapper {

    Task toTask(final TaskDTO dto);
    TaskDTO toTaskDTO(final Task tash);
}
