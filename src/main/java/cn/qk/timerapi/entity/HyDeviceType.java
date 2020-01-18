package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hy_device_type", schema = "dfe_demo2", catalog = "")
public class HyDeviceType {
    private int id;
    private String deviceTypeName;
    private String useFlag;
    private Timestamp createDate;
    private String createUser;
    private Byte isMulti;
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
    @Column(name = "device_type_name", nullable = true, length = 32)
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
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
    @Column(name = "is_multi", nullable = true)
    public Byte getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(Byte isMulti) {
        this.isMulti = isMulti;
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
        HyDeviceType that = (HyDeviceType) o;
        return id == that.id &&
                Objects.equals(deviceTypeName, that.deviceTypeName) &&
                Objects.equals(useFlag, that.useFlag) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(isMulti, that.isMulti) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceTypeName, useFlag, createDate, createUser, isMulti, remark);
    }
}
