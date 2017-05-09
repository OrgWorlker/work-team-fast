package com.wtf.domain.service;

import com.wtf.interfaces.repository.BaseMapper;
import com.wtf.interfaces.service.IBaseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/9.
 *
 * @param <T> the type parameter
 * @param <M> the type parameter
 */
public class BaseServiceImpl<T, M extends BaseMapper<T>> implements IBaseService<T> {

    private M mapper;

    /**
     * Insert int.
     *
     * @param pojo the pojo
     * @return the int
     */
    public int insert(T pojo) {
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
        return this.mapper.update(pojo);
    }

    public T findById(Long id) {
        return this.mapper.findById(id);
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

    /**
     * Gets mapper.
     *
     * @return the mapper
     */
    public M getMapper() {
        return this.mapper;
    }
}
