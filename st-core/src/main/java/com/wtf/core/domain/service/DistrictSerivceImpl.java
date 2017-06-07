package com.wtf.core.domain.service;

import com.wtf.core.domain.model.District;
import com.wtf.core.interfaces.repository.IDistrictMapper;
import com.wtf.core.interfaces.service.IDistrictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictSerivceImpl extends BaseServiceImpl<District, IDistrictMapper> implements IDistrictService {
    @Override
    public List<District> findByPid(Long pid) throws Exception {
        return this.getMapper().findByPid(pid);
    }
}
