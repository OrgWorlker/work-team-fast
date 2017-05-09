package com.wtf.interfaces.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.wtf.domain.model.Task;

/**
 * The interface Task mapper.
 */
@Mapper
public interface ITaskMapper extends BaseMapper<Task> {

}