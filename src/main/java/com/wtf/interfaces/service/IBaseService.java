package com.wtf.interfaces.service;

import com.wtf.domain.model.UserLevel;

import java.util.List;

/**
 * Created by zc.lin on 2017/5/9.
 *
 * @param <T> the type parameter
 */
public interface IBaseService<T> {

    /**
     * Insert int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int insert(T pojo);

    /**
     * Insert selective int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int insertSelective(T pojo);

    /**
     * Insert list int.
     *
     * @param pojos the pojos
     * @return the int
     */
    int insertList(List<T> pojos);

    /**
     * Update int.
     *
     * @param pojo the pojo
     * @return the int
     */
    int update(T pojo);

    /**
     * Find by id t.
     *
     * @param id the id
     * @return the t
     */
    T findById(Long id);
}
