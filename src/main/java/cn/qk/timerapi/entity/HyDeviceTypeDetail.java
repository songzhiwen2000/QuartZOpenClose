package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hy_device_type_detail", schema = "dfe_demo2", catalog = "")
public class HyDeviceTypeDetail {
    private int id;
    private Integer pId;
    private String deviceTypeName;
    private String fieldCode;
    private Timestamp createDate;
    private String createUser;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "p_id", nullable = true)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "device_type_name", nullable = true, length = 32)
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Basic
    @Column(name = "field_code", nullable = true, length = 32)
    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
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
    @Column(name = "remark", nullable = true, length = 256)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyDeviceTypeDetail that = (HyDeviceTypeDetail) o;
        return id == that.id &&
                Objects.equals(pId, that.pId) &&
                Objects.equals(deviceTypeName, that.deviceTypeName) &&
                Objects.equals(fieldCode, that.fieldCode) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pId, deviceTypeName, fieldCode, createDate, createUser, remark);
    }
}
