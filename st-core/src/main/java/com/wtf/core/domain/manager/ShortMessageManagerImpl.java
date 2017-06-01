package com.wtf.core.domain.manager;

import com.wtf.core.domain.factory.MessageQueueFactory;
import com.wtf.core.interfaces.manager.IShortMesageManager;
import com.wtf.infsc.infrastructure.stereotype.Manager;

import javax.annotation.Resource;

/**
 * The type Short message manager.
 */
@Manager
public class ShortMessageManagerImpl implements IShortMesageManager {
    /**
     * The Message queue factory.
     */
    @Resource
    MessageQueueFactory messageQueueFactory;

    @Override
    public int send(String phoneNum) throws Exception {
        this.messageQueueFactory.sendShortMessage(phoneNum);
        return 1;
    }
}
