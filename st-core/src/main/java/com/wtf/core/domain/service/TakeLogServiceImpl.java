package com.wtf.core.domain.service;

import com.wtf.core.domain.model.TakeLog;
import com.wtf.core.interfaces.repository.ITakeLogMapper;
import com.wtf.core.interfaces.service.ITakeLogService;
import org.springframework.stereotype.Service;

/**
 * The type Take log service.
 */
@Service
public class TakeLogServiceImpl extends  BaseServiceImpl<TakeLog, ITakeLogMapper> implements ITakeLogService {

}
