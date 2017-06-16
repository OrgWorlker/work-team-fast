package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.BaseModel;

import java.util.List;
/**
 * Created by zc.lin on 2017/5/9.
 *
 * @param <T> the type parameter
 */
public interface IBaseService<T extends BaseModel> {

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
