package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hy_device", schema = "dfe_demo2", catalog = "")
public class HyDevice {
    private Integer id;
    private Integer imuSerialCode;
    private Integer imuNum;
    private Integer deviceAddr;
    private Integer deviceTypeId;
    private Integer deviceTypeDetailId;
    private Integer projectId;
    private String deviceName;
    private String deviceSerialNo;
    private Integer deviceMark;
    private String useFlag;
    private Timestamp runTime;
    private Timestamp createDate;
    private String createUser;
    private Integer outerNum;
    private Integer innerNum;
    private String remark;
    private String devicePinp;
    private String deviceChangj;
    private String deviceXingh;
    private Double deviceEdgl;
    private String deviceFjlx;
    private Double heatPower;
    private Double coldPower;
    private String acModel;
    private String pmModel;
    private String rtuId;
    private String rtuRange;
    private Integer otherDeviceId;
    private String calcParamName;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imu_serial_code", nullable = true)
    public Integer getImuSerialCode() {
        return imuSerialCode;
    }

    public void setImuSerialCode(Integer imuSerialCode) {
        this.imuSerialCode = imuSerialCode;
    }

    @Basic
    @Column(name = "imu_num", nullable = true)
    public Integer getImuNum() {
        return imuNum;
    }

    public void setImuNum(Integer imuNum) {
        this.imuNum = imuNum;
    }

    @Basic
    @Column(name = "device_addr", nullable = true)
    public Integer getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(Integer deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    @Basic
    @Column(name = "device_type_id", nullable = true)
    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    @Basic
    @Column(name = "device_type_detail_id", nullable = true)
    public Integer getDeviceTypeDetailId() {
        return deviceTypeDetailId;
    }

    public void setDeviceTypeDetailId(Integer deviceTypeDetailId) {
        this.deviceTypeDetailId = deviceTypeDetailId;
    }

    @Basic
    @Column(name = "project_id", nullable = true)
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "device_name", nullable = true, length = 32)
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "device_serial_no", nullable = true, length = 32)
    public String getDeviceSerialNo() {
        return deviceSerialNo;
    }

    public void setDeviceSerialNo(String deviceSerialNo) {
        this.deviceSerialNo = deviceSerialNo;
    }

    @Basic
    @Column(name = "device_mark", nullable = true)
    public Integer getDeviceMark() {
        return deviceMark;
    }

    public void setDeviceMark(Integer deviceMark) {
        this.deviceMark = deviceMark;
    }

    @Basic
    @Column(name = "use_flag", nullable = true, length = 2)
    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    @Basic
    @Column(name = "run_time", nullable = true)
    public Timestamp getRunTime() {
        return runTime;
    }

    public void setRunTime(Timestamp runTime) {
        this.runTime = runTime;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_user", nullable = true, length = 32)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "outer_num", nullable = true)
    public Integer getOuterNum() {
        return outerNum;
    }

    public void setOuterNum(Integer outerNum) {
        this.outerNum = outerNum;
    }

    @Basic
    @Column(name = "inner_num", nullable = true)
    public Integer getInnerNum() {
        return innerNum;
    }

    public void setInnerNum(Integer innerNum) {
        this.innerNum = innerNum;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 256)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "device_pinp", nullable = true, length = 50)
    public String getDevicePinp() {
        return devicePinp;
    }

    public void setDevicePinp(String devicePinp) {
        this.devicePinp = devicePinp;
    }

    @Basic
    @Column(name = "device_changj", nullable = true, length = 100)
    public String getDeviceChangj() {
        return deviceChangj;
    }

    public void setDeviceChangj(String deviceChangj) {
        this.deviceChangj = deviceChangj;
    }

    @Basic
    @Column(name = "device_xingh", nullable = true, length = 50)
    public String getDeviceXingh() {
        return deviceXingh;
    }

    public void setDeviceXingh(String deviceXingh) {
        this.deviceXingh = deviceXingh;
    }

    @Basic
    @Column(name = "device_edgl", nullable = true, precision = 0)
    public Double getDeviceEdgl() {
        return deviceEdgl;
    }

    public void setDeviceEdgl(Double deviceEdgl) {
        this.deviceEdgl = deviceEdgl;
    }

    @Basic
    @Column(name = "device_fjlx", nullable = true, length = 2)
    public String getDeviceFjlx() {
        return deviceFjlx;
    }

    public void setDeviceFjlx(String deviceFjlx) {
        this.deviceFjlx = deviceFjlx;
    }

    @Basic
    @Column(name = "heat_power", nullable = true, precision = 0)
    public Double getHeatPower() {
        return heatPower;
    }

    public void setHeatPower(Double heatPower) {
        this.heatPower = heatPower;
    }

    @Basic
    @Column(name = "cold_power", nullable = true, precision = 0)
    public Double getColdPower() {
        return coldPower;
    }

    public void setColdPower(Double coldPower) {
        this.coldPower = coldPower;
    }

    @Basic
    @Column(name = "ac_model", nullable = true, length = 2)
    public String getAcModel() {
        return acModel;
    }

    public void setAcModel(String acModel) {
        this.acModel = acModel;
    }

    @Basic
    @Column(name = "pm_model", nullable = true, length = 2)
    public String getPmModel() {
        return pmModel;
    }

    public void setPmModel(String pmModel) {
        this.pmModel = pmModel;
    }

    @Basic
    @Column(name = "rtu_id", nullable = true, length = 10)
    public String getRtuId() {
        return rtuId;
    }

    public void setRtuId(String rtuId) {
        this.rtuId = rtuId;
    }

    @Basic
    @Column(name = "rtu_range", nullable = true, length = 10)
    public String getRtuRange() {
        return rtuRange;
    }

    public void setRtuRange(String rtuRange) {
        this.rtuRange = rtuRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyDevice hyDevice = (HyDevice) o;
        return id == hyDevice.id &&
                Objects.equals(imuSerialCode, hyDevice.imuSerialCode) &&
                Objects.equals(imuNum, hyDevice.imuNum) &&
                Objects.equals(deviceAddr, hyDevice.deviceAddr) &&
                Objects.equals(deviceTypeId, hyDevice.deviceTypeId) &&
                Objects.equals(deviceTypeDetailId, hyDevice.deviceTypeDetailId) &&
                Objects.equals(projectId, hyDevice.projectId) &&
                Objects.equals(deviceName, hyDevice.deviceName) &&
                Objects.equals(deviceSerialNo, hyDevice.deviceSerialNo) &&
                Objects.equals(deviceMark, hyDevice.deviceMark) &&
                Objects.equals(useFlag, hyDevice.useFlag) &&
                Objects.equals(runTime, hyDevice.runTime) &&
                Objects.equals(createDate, hyDevice.createDate) &&
                Objects.equals(createUser, hyDevice.createUser) &&
                Objects.equals(outerNum, hyDevice.outerNum) &&
                Objects.equals(innerNum, hyDevice.innerNum) &&
                Objects.equals(remark, hyDevice.remark) &&
                Objects.equals(devicePinp, hyDevice.devicePinp) &&
                Objects.equals(deviceChangj, hyDevice.deviceChangj) &&
                Objects.equals(deviceXingh, hyDevice.deviceXingh) &&
                Objects.equals(deviceEdgl, hyDevice.deviceEdgl) &&
                Objects.equals(deviceFjlx, hyDevice.deviceFjlx) &&
                Objects.equals(heatPower, hyDevice.heatPower) &&
                Objects.equals(coldPower, hyDevice.coldPower) &&
                Objects.equals(acModel, hyDevice.acModel) &&
                Objects.equals(pmModel, hyDevice.pmModel) &&
                Objects.equals(rtuId, hyDevice.rtuId) &&
                Objects.equals(rtuRange, hyDevice.rtuRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imuSerialCode, imuNum, deviceAddr, deviceTypeId, deviceTypeDetailId, projectId, deviceName, deviceSerialNo, deviceMark, useFlag, runTime, createDate, createUser, outerNum, innerNum, remark, devicePinp, deviceChangj, deviceXingh, deviceEdgl, deviceFjlx, heatPower, coldPower, acModel, pmModel, rtuId, rtuRange);
    }

    @Basic
    @Column(name = "other_device_id")
    public Integer getOtherDeviceId() {
        return otherDeviceId;
    }

    public void setOtherDeviceId(Integer otherDeviceId) {
        this.otherDeviceId = otherDeviceId;
    }

    @Basic
    @Column(name = "calc_param_name")
    public String getCalcParamName() {
        return calcParamName;
    }

    public void setCalcParamName(String calcParamName) {
        this.calcParamName = calcParamName;
    }
}
