package com.wtf.core.interfaces.service;

import com.wtf.core.domain.model.TakeLog;

import java.util.List;

/**
 * The interface Take log service.
 */
public interface ITakeLogService extends  IBaseService<TakeLog> {

    List<TakeLog> findByUserIdAndType( Long userId, int type) throws Exception;
}
