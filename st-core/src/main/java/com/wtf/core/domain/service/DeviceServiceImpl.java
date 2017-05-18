package com.wtf.core.domain.service;

import com.wtf.core.domain.model.Device;
import com.wtf.core.interfaces.repository.IDeviceMapper;
import com.wtf.core.interfaces.service.IDeviceService;
import org.springframework.stereotype.Service;

/**
 * The type Device service.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, IDeviceMapper> implements IDeviceService {

}
