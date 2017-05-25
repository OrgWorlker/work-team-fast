package com.wtf.buyers.application;

import com.wtf.core.interfaces.manager.IGoodsManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The type Goods controller.
 */
@RestController
public class GoodsController {

    /**
     * The Goods manager.
     */
    @Resource
    private IGoodsManager goodsManager;

    /**
     * Find by id object.
     *
     * @param id the id
     * @return the object
     * @throws Exception the exception
     */
    @RequestMapping("goods/{id}")
    public Object findById(@PathVariable Long id) throws Exception {
        return this.goodsManager.findById(id);
    }
}
