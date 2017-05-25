package com.wtf.core.interfaces.manager;


import com.wtf.core.domain.model.Goods;

/**
 * The interface Goods manager.
 */
public interface IGoodsManager {

    /**
     * Find by id goods.
     *
     * @param id the id
     * @return the goods
     * @throws Exception the exception
     */
    Goods findById(Long id) throws Exception;

}
