package com.wtf.core.domain.service;


import com.wtf.core.domain.model.BaseModel;
import com.wtf.core.interfaces.repository.BaseMapper;
import com.wtf.core.interfaces.service.IBaseService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/9.
 *
 * @param <T> the type parameter
 * @param <M> the type parameter
 */
public class BaseServiceImpl<T extends BaseModel, M extends BaseMapper<T>> implements IBaseService<T> {

    private M mapper;

    /**
     * Insert int.
     *
     * @param pojo the pojo
     * @return the int
     */
    public int insert(T pojo) {
        pojo.setCrtTime(new Date());
        return this.mapper.insert(pojo);
    }

    /**
     * Insert selective int.
     *
     * @param pojo the pojo
     * @return the int
     */
    public int insertSelective(T pojo) {
        return this.mapper.insertSelective(pojo);
    }

    /**
     * Insert list int.
     *
     * @param pojos the pojos
     * @return the int
     */
    public int insertList(List<T> pojos) {
        return this.mapper.insertList(pojos);
    }

    /**
     * Update int.
     *
     * @param pojo the pojo
     * @return the int
     */
    public int update(T pojo) {
        pojo.setUpdTime(new Date());
        return this.mapper.update(pojo);
    }

    public T findById(Long id) {
        return this.mapper.findById(id);
    }

    /**
     * Find all list.
     *
     * @param pojo the t
     * @return the list
     */
    public List<T> findAll(T pojo) {
        return this.getMapper().findAll(pojo);
    }


    /**
     * Delete int.
     *
     * @param id the id
     * @return the int
     */
    public int delete(Long id) {
        return this.getMapper().delete(id);
    }

    /**
     * Gets mapper.
     *
     * @return the mapper
     */
    public M getMapper() {
        return this.mapper;
    }

    /**
     * Sets mapper.
     *
     * @param mapper the mapper
     */
    @Resource
    public void setMapper(M mapper) {
        this.mapper = mapper;
    }
}
