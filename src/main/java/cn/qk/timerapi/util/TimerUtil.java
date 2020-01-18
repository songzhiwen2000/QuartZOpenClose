package cn.qk.timerapi.util;

import cn.qk.timerapi.dao.HyDeviceModelRepository;
import cn.qk.timerapi.dao.HyDeviceRepository;
import cn.qk.timerapi.entity.*;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Component
public class TimerUtil {
    @Autowired
    private HyDeviceModelRepository hyDeviceModelRepository;
    @Autowired
    private MongoQueryTool mongoQueryTool;


    private static Logger logger = Logger.getLogger(TimerUtil.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //设备类型列表
    private final Integer[] devTypeList = {MongoConstants.SYSTEM_TABLE, MongoConstants.ELECTRIC_TABLE, MongoConstants.HEATER_METER_TABLE};

    private List<HyDevice> deviceList = null;//存储所有设备信息
    private Map<Integer, Map<String, String>> fieldUnitMap = null;//存储所有设备的字段信息 用于获取每个设备的单位等信息
    private Map<Integer, List<HyExpressionParam>> paramMap = null;//存储所有项目的参数 用于计算
    private Map<Integer, List<HyExpressionCopy>> expressionMap = null;//存储所有项目的计算公式




    public void executeMinByTime() {
        HyDeviceModel item = new HyDeviceModel();
        item.setModelType(30);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id");//id不参与查询
        Example<HyDeviceModel> example = Example.of(item, matcher);
        List<HyDeviceModel> list = hyDeviceModelRepository.findAll(example);
        list.forEach(p-> System.out.println(p.getModelName()));
    }


    //用于求统计时间，求出当前分钟前一条记录的时间
    public long getStatisticTime(String tableName, Integer deviceId, Long startTime) {
        MongoQueryParams params = new MongoQueryParams();
        params.addRange(MongoConstants.DATA_TIME_FIELD, startTime, null);//取大于等于最小值，小于最大值的数据
        params.addQueryField(MongoConstants.DATA_TIME_FIELD);//添加日期字段
        params.addParam(MongoConstants.DEVICE_ID_FIELD, deviceId);
        params.addSortParams(MongoConstants.DATA_TIME_FIELD, MongoQueryParams.SORT_NAGETIVE);//按照时间升序
        List<DBObject> list = mongoQueryTool.queryMongoObj(tableName, params, 1);
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Long.parseLong(list.get(0).get(MongoConstants.DATA_TIME_FIELD).toString());
    }


}
