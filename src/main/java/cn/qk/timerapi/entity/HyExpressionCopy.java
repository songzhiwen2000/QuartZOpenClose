package cn.qk.timerapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hy_expression_copy", schema = "dfe_demo2", catalog = "")
public class HyExpressionCopy {
    private int id;
    private Integer projectId;
    private String calcParam;
    private String calcExpression;

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
    @Column(name = "calc_param")
    public String getCalcParam() {
        return calcParam;
    }

    public void setCalcParam(String calcParam) {
        this.calcParam = calcParam;
    }

    @Basic
    @Column(name = "calc_expression")
    public String getCalcExpression() {
        return calcExpression;
    }

    public void setCalcExpression(String calcExpression) {
        this.calcExpression = calcExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyExpressionCopy that = (HyExpressionCopy) o;
        return id == that.id &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(calcParam, that.calcParam) &&
                Objects.equals(calcExpression, that.calcExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, calcParam, calcExpression);
    }

}
