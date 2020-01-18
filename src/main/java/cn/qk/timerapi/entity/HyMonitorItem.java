package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hy_monitor_item", schema = "dfe_demo2", catalog = "")
public class HyMonitorItem {
    private int id;
    private Integer deviceId;
    private Integer modelType;
    private Integer propertyNo;
    private Integer monitorType;
    private Integer propertyIndex;
    private String propertyName;
    private String unit;
    private Byte customerVisible;
    private String useFlag;
    private Integer propertyType;
    private Integer propertyClass;
    private Integer modelId;
    private Double minValue;
    private Double maxValue;
    private Integer deci;
    private Integer paramIdx;
    private Timestamp createDate;
    private String createUser;
    private String customerName;
    private String fieldCode;
    private String controlFlag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_id")
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "model_type")
    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    @Basic
    @Column(name = "property_no")
    public Integer getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(Integer propertyNo) {
        this.propertyNo = propertyNo;
    }

    @Basic
    @Column(name = "monitor_type")
    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    @Basic
    @Column(name = "property_index")
    public Integer getPropertyIndex() {
        return propertyIndex;
    }

    public void setPropertyIndex(Integer propertyIndex) {
        this.propertyIndex = propertyIndex;
    }

    @Basic
    @Column(name = "property_name")
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "customer_visible")
    public Byte getCustomerVisible() {
        return customerVisible;
    }

    public void setCustomerVisible(Byte customerVisible) {
        this.customerVisible = customerVisible;
    }

    @Basic
    @Column(name = "use_flag")
    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    @Basic
    @Column(name = "property_type")
    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    @Basic
    @Column(name = "property_class")
    public Integer getPropertyClass() {
        return propertyClass;
    }

    public void setPropertyClass(Integer propertyClass) {
        this.propertyClass = propertyClass;
    }

    @Basic
    @Column(name = "model_id")
    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "min_value")
    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    @Basic
    @Column(name = "max_value")
    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Basic
    @Column(name = "deci")
    public Integer getDeci() {
        return deci;
    }

    public void setDeci(Integer deci) {
        this.deci = deci;
    }

    @Basic
    @Column(name = "param_idx")
    public Integer getParamIdx() {
        return paramIdx;
    }

    public void setParamIdx(Integer paramIdx) {
        this.paramIdx = paramIdx;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "field_code")
    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    @Basic
    @Column(name = "control_flag")
    public String getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(String controlFlag) {
        this.controlFlag = controlFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyMonitorItem item = (HyMonitorItem) o;
        return id == item.id &&
                Objects.equals(deviceId, item.deviceId) &&
                Objects.equals(modelType, item.modelType) &&
                Objects.equals(propertyNo, item.propertyNo) &&
                Objects.equals(monitorType, item.monitorType) &&
                Objects.equals(propertyIndex, item.propertyIndex) &&
                Objects.equals(propertyName, item.propertyName) &&
                Objects.equals(unit, item.unit) &&
                Objects.equals(customerVisible, item.customerVisible) &&
                Objects.equals(useFlag, item.useFlag) &&
                Objects.equals(propertyType, item.propertyType) &&
                Objects.equals(propertyClass, item.propertyClass) &&
                Objects.equals(modelId, item.modelId) &&
                Objects.equals(minValue, item.minValue) &&
                Objects.equals(maxValue, item.maxValue) &&
                Objects.equals(deci, item.deci) &&
                Objects.equals(paramIdx, item.paramIdx) &&
                Objects.equals(createDate, item.createDate) &&
                Objects.equals(createUser, item.createUser) &&
                Objects.equals(customerName, item.customerName) &&
                Objects.equals(fieldCode, item.fieldCode) &&
                Objects.equals(controlFlag, item.controlFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, modelType, propertyNo, monitorType, propertyIndex, propertyName, unit, customerVisible, useFlag, propertyType, propertyClass, modelId, minValue, maxValue, deci, paramIdx, createDate, createUser, customerName, fieldCode, controlFlag);
    }
}
