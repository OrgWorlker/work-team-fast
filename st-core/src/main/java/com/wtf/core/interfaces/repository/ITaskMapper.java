package com.wtf.core.interfaces.repository;

import com.wtf.core.domain.model.Task;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface Task mapper.
 */
@Mapper
public interface ITaskMapper extends BaseMapper<Task> {

}