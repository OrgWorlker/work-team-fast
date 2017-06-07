package com.wtf.core.interfaces.manager;

import java.util.Map;

/**
 * The interface District manager.
 */
public interface IDistrictManager {

    /**
     * District tree list.
     *
     * @return the list
     * @throws Exception the exception
     */
    Map<String, Object> districtTree() throws Exception;
}
