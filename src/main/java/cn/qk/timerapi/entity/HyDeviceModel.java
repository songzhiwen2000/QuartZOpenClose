package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hy_device_model", schema = "dfe_demo2", catalog = "")
public class HyDeviceModel {
    private int id;
    private Integer deviceType;
    private Integer upperId;
    private String tableName;
    private String modelName;
    private Integer modelType;
    private String createUser;
    private Timestamp createDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_type")
    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "upper_id")
    public Integer getUpperId() {
        return upperId;
    }

    public void setUpperId(Integer upperId) {
        this.upperId = upperId;
    }

    @Basic
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "model_name")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyDeviceModel that = (HyDeviceModel) o;
        return id == that.id &&
                Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(upperId, that.upperId) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(modelType, that.modelType) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceType, upperId, tableName, modelName, modelType, createUser, createDate);
    }
}
