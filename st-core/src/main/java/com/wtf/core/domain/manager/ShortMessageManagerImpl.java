package com.wtf.core.domain.manager;

import com.wtf.core.domain.event.ShortMsgEvent;
import com.wtf.core.interfaces.manager.IShortMesageManager;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;

/**
 * The type Short message manager.
 */
@ManagerService
public class ShortMessageManagerImpl implements IShortMesageManager {
    /**
     * The Message queue factory.
     */
    @Resource
    ShortMsgEvent shortMsgEvent;

    @Override
    public int send(String phoneNum) throws Exception {
        this.shortMsgEvent.sendShortMessage(phoneNum);
        return 1;
    }
}
