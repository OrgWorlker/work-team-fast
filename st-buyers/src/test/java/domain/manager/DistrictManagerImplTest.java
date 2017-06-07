package domain.manager;

import com.alibaba.fastjson.JSON;
import com.wtf.BuyersApplication;
import com.wtf.core.interfaces.manager.IDistrictManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest(classes = BuyersApplication.class)
@RunWith(SpringRunner.class)
public class DistrictManagerImplTest {
    @Resource
    private IDistrictManager districtManager;

    @Test
    public void districtTree() throws Exception {
        final Map<String, Object> maps = this.districtManager.districtTree();
        final String string = JSON.toJSONString(maps);
        System.out.println(string);
    }

}