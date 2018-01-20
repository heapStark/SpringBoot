package heapstark.dao.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Mapper
@Repository
public interface PropertyConfigMapper {
    @Select("select propkey, propvalue  from config")
    @MapKey("propkey")
    List<HashMap<String, String>> findProperty();

    @Select("select propkey, propvalue  from config")
    List<HashMap<String, String>>findPropertyMap(Map map);

}

