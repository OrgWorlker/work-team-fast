package com.wtf.core.domain.manager;

import com.wtf.core.domain.model.District;
import com.wtf.core.interfaces.manager.IDistrictManager;
import com.wtf.core.interfaces.service.IDistrictService;
import com.wtf.infsc.infrastructure.stereotype.ManagerService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagerService
public class DistrictManagerImpl implements IDistrictManager {

    @Resource
    private IDistrictService districtService;
    /**
     * District tree list.
     *
     * @return the list
     * @throws Exception the exception
     */
    @Override
    public Map<String, Object> districtTree() throws Exception {
        final List<District> lists = this.districtService.findByPid(0L);
        final Map<String , Object> result = new HashMap<>();
        final List<Map<String, Object>> mapList = new ArrayList<>();
        if (lists != null && !lists.isEmpty()) {
            District china = lists.get(0);
            final List<District> provinces = this.districtService.findByPid(china.getId());
            for (District pd : provinces) {
                final Map<String, Object> pdmap = new HashMap<>();
                pdmap.put("id", pd.getId());
                pdmap.put("name", pd.getName());
                final List<Map<String, Object>> cityspdmap =  new ArrayList<>();
                final List<District> citys = this.districtService.findByPid(pd.getId());
                for (District city : citys) {
                    final Map<String, Object> ctmap = new HashMap<>();
                    final List<Map<String, Object>> ctMapList =  new ArrayList<>();
                    final List<District> areas = this.districtService.findByPid(city.getId());
                    ctmap.put("id", city.getId());
                    ctmap.put("name", city.getName());
                    for (District area : areas) {
                        final Map<String, Object> areaMap = new HashMap<>();
                        areaMap.put("id", area.getId());
                        areaMap.put("name", area.getName());
                        ctMapList.add(areaMap);
                    }
                    ctmap.put("child", ctMapList);
                    cityspdmap.add(ctmap);
                }
                pdmap.put("child", cityspdmap);
                mapList.add(pdmap);
            }
        }
        final District district = new District();
        district.setLevel(0);
        result.put("data", mapList);
        return result;
    }
}
