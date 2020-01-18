package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hy_expression_param", schema = "dfe_demo2", catalog = "")
public class HyExpressionParam {
    private int id;
    private Integer projectId;
    private Integer deviceId;
    private String paramName;
    private String fieldCode;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "project_id")
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
    @Column(name = "param_name")
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Basic
    @Column(name = "field_code")
    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyExpressionParam that = (HyExpressionParam) o;
        return id == that.id &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(paramName, that.paramName) &&
                Objects.equals(fieldCode, that.fieldCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, deviceId, paramName, fieldCode);
    }
}
