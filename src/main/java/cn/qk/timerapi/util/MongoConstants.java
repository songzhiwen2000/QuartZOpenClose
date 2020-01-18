package cn.qk.timerapi.util;

public class MongoConstants {

    public static final String DATA_TABLE_MIN = "data_min";        //分钟数据表
    public static final String DATA_TABLE_HOUR = "data_hour";        //小时数据表
    public static final String DATA_TABLE_DAY = "data_day";        //每天数据表
    public static final String DATA_TABLE_MONTH = "data_month";        //每月数据表
    public static final Integer SYSTEM_TABLE = 501;        //系统表
    public static final Integer ELECTRIC_TABLE = 508;      //电表
    public static final Integer HEATER_METER_TABLE = 509;  //热表类型
    public static final String METER_TABLE = "meter";       //热量表



    //环境参数
    public static final String HOST_POWER = "host-power";     //主机功率（JSON字段）
    public static final String COLD_POWER = "cold-power";     //冷源系统功率（JSON字段）
    public static final String TRANS_POWER = "trans-power";     //输配系统功率(JSON字段)
    public static final String AIR_POWER = "air-power";     //机房系统功率(JSON字段)
    public static final String HOST_CONSUME = "host-consume";     //主机耗电量（JSON字段）
    public static final String COLD_CONSUME = "cold-consume";     //冷源系统耗电量（JSON字段）
    public static final String TRANS_CONSUME = "trans-consume";     //输配系统耗电量(JSON字段)
    public static final String AIR_CONSUME = "air-consume";     //机房系统耗电量(JSON字段)
    public static final String HOST_EFFIC = "host-effic";     //主机能效(JSON字段)
    public static final String COLD_EFFIC = "cold-effic";     //冷热源系统能效(JSON字段)
    public static final String TRANS_EFFIC = "trans-effic";     //输配系统能效(JSON字段)
    public static final String AIR_EFFIC = "air-effic";     //机房系统能效(JSON字段)
    public static final String STATISTIC_TIME = "statistic-time";        //统计时间(JSON字段)
    public static final String CHECK_TIME = "check-time";               //校核时间(JSON字段)
    public static final String CURRENT_TIME = "current-time";   //数据的采集时间

    public static final String OUT_TEMP = "outer-temp";     //室外温度（501）
    public static final String OUT_HUMD = "outer-humd";     //室外湿度（501）

    //电表
    public static final String CH_TAPOW = "ch-TApow";      //总有功功率(508)
    public static final String CH_TAKWH = "ch-TAkwh";      //总有功电能(508)


    //主机热表参数
    public static final String FREEZE_INTEMP_M = "in-temp-m";      //主机热表出水温度（meter）
    public static final String FREEZE_OUTTEMP_M = "out-temp-m";      //主机热表进水水温度（meter）
    public static final String FREEZE_FLOW_M = "flow-m";          //主机热表瞬时流量 （meter）
    public static final String FREEZE_HEAT_M = "heat-m";          //主机热表瞬时冷热量（meter）
    public static final String FREEZE_THEAT_M = "theat-m";        //主机热表累计热量（meter）
    public static final String FREEZE_TCOLD_M = "tcold-m";        //主机热表累计冷量（meter）
    //源总热表参数
    public static final String FREEZE_INTEMP_Y = "in-temp-y";      //主机热表出水温度（meter）
    public static final String FREEZE_OUTTEMP_Y = "out-temp-y";      //主机热表进水水温度（meter）
    public static final String FREEZE_FLOW_Y = "flow-y";          //主机热表瞬时流量 （meter）
    public static final String FREEZE_HEAT_Y = "heat-y";          //主机热表瞬时冷热量（meter）
    public static final String FREEZE_THEAT_Y = "theat-y";        //主机热表累计热量（meter）
    public static final String FREEZE_TCOLD_Y = "tcold-y";        //主机热表累计冷量（meter）
    //输配热表参数
    public static final String FREEZE_INTEMP_T = "in-temp-t";      //主机热表出水温度（meter）
    public static final String FREEZE_OUTTEMP_T = "out-temp-t";      //主机热表进水水温度（meter）
    public static final String FREEZE_FLOW_T = "flow-t";          //主机热表瞬时流量 （meter）
    public static final String FREEZE_HEAT_T = "heat-t";          //主机热表瞬时冷热量（meter）
    public static final String FREEZE_THEAT_T = "theat-t";        //主机热表累计热量（meter）
    public static final String FREEZE_TCOLD_T = "tcold-t";        //主机热表累计冷量（meter）

    //机房热表参数
    public static final String FREEZE_INTEMP = "in-temp";      //机房热表出水温度（meter）
    public static final String FREEZE_OUTTEMP = "out-temp";      //机房热表进水水温度（meter）
    public static final String FREEZE_FLOW = "flow";          //机房热表瞬时流量 （meter）
    public static final String FREEZE_HEAT = "heat";          //机房热表瞬时冷热量（meter）
    public static final String FREEZE_THEAT = "theat";        //机房热表累计热量（meter）
    public static final String FREEZE_TCOLD = "tcold";        //机房热表累计冷量（meter）

    //通用计算公式变量列表

    //功率变量
    public static final String PM_POW = "pm";        //主机功率变量
    public static final String PY_POW = "py";        //源总功率变量
    public static final String PT_POW = "pt";        //输配功率变量
    public static final String PZ_POW = "pz";        //机房功率变量
    //电量变量
    public static final String PM_KWH = "Pm";        //主机电量变量
    public static final String PY_KWH = "Py";        //源总电量变量
    public static final String PT_KWH = "Pt";        //输配电量变量
    public static final String PZ_KWH = "Pz";        //机房电量变量

    public static final String COPM = "COPm";        //主机COP变量
    public static final String COPY = "COPy";        //源总COP变量
    public static final String COPT = "COPt";        //输配COP变量
    public static final String COPZ = "COPz";        //机房COP变量

    //热表计算公式 表达式变量名-----------主机
    public static final String TMG = "Tmg";        //主机供水温度
    public static final String TMH = "Tmh";        //主机回水温度
    public static final String FM = "Fm";        //主机流量
    public static final String QM = "qm";        //主机瞬时冷热量
    public static final String QMH = "Qmh";        //主机累计热量
    public static final String QMC = "Qmc";        //主机累计冷量

    //热表计算公式 表达式变量名-----------源总
    public static final String TYG = "Tyg";        //源总供水温度
    public static final String TYH = "Tyh";        //源总回水温度
    public static final String FY = "Fy";        //源总流量
    public static final String QY = "qy";        //源总瞬时冷热量
    public static final String QYH = "Qyh";        //源总累计热量
    public static final String QYC = "Qyc";        //源总累计冷量

    //热表计算公式 表达式变量名-----------输配
    public static final String TTG = "Ttg";        //输配供水温度
    public static final String TTH = "Tth";        //输配回水温度
    public static final String FT = "Ft";        //输配流量
    public static final String QT = "qt";        //输配瞬时冷热量
    public static final String QTH = "Qth";        //输配累计热量
    public static final String QTC = "Qtc";        //输配累计冷量

    //热表计算公式 表达式变量名-----------机房
    public static final String TZG = "Tzg";        //机房供水温度
    public static final String ZTH = "Tzh";        //机房回水温度
    public static final String FZ = "Fz";        //机房流量
    public static final String QZ = "qz";        //机房瞬时冷热量
    public static final String QZH = "Qzh";        //机房累计热量
    public static final String QZC = "Qzc";        //机房累计冷量




    public static final String DEVICE_ID_FIELD = "device_id";            //设备字段
    public static final String PROJECT_ID_FIELD = "project_id";            //设备字段


    public static final String DATA_TIME_FIELD = "DT";
    public static final String WARN_VALUE_FIELD = "warn_value";
    public static final String END_TIME_FIELD = "end_time";
    public static final String MODEL_TYPE_FIELD = "model_id";
    public static final String PROPERTY_INDEX_FIELD = "property_id";
    public static final String BIT_INDEX_FIELD = "bit_index";



}
