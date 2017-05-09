package com.wtf.domain.service;

import com.wtf.domain.model.Device;
import com.wtf.interfaces.repository.IDeviceMapper;
import com.wtf.interfaces.service.IDeviceService;
import org.springframework.stereotype.Service;

/**
 * The type Device service.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, IDeviceMapper> implements IDeviceService {

}
