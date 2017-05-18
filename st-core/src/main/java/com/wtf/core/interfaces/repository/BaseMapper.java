package com.wtf.core.interfaces.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zc.lin on 2017/5/9.
 */
public interface BaseMapper<T> {

    /**
     * Insert int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int insert(@Param("pojo") T pojo);

    /**
     * Insert selective int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int insertSelective(@Param("pojo") T pojo);

    /**
     * Insert list int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int insertList(@Param("pojos") List<T> pojo);

    /**
     * Update int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int update(@Param("pojo") T pojo);

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    T findById(Long id);

    /**
     * Find all list.
     *
     * @param pojo the pojo
     * @return the list
     */
    List<T> findAll(T pojo);


    /**
     * Delete int.
     *
     * @param id the id
     * @return the int
     */
    int delete(Long id);
}
