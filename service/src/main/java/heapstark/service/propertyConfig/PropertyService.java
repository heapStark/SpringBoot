package heapstark.service.propertyConfig;

import java.util.HashMap;
import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
public interface PropertyService {
    List<HashMap<String, String>> findProperty();
}
