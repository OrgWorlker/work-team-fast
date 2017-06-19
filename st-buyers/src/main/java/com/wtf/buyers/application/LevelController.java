package com.wtf.buyers.application;

import com.wtf.core.domain.model.TakeLog;
import com.wtf.core.infrastructure.adapter.ControllerAdapter;
import com.wtf.core.interfaces.manager.ITakeLogManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("level")
public class LevelController extends ControllerAdapter {

    @Resource
    private ITakeLogManager takeLogManager;

    @PostMapping("take")
    public String take(TakeLog takeLog) {
        final int flag = this.takeLogManager.save(takeLog);
        if (flag > 0) {
            return SUCCESS;
        }
        return ERROR;
    }
}
