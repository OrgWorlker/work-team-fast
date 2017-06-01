package com.wtf.buyers.application;

import com.wtf.core.interfaces.manager.ITbUserManager;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TaskController {
    @Resource
    ITbUserManager tbUserManager;


}
