package com.carapp.carscrapordermanager.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemVO {

    private String id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "配件类型")
    @NotNull(message = "配件类型不能为空")
    @Min(value = 1, message = "配件类型错误")
    private Integer partsType;

    @ApiModelProperty(value = "配件名称")
    @NotBlank(message = "配件名称不能为空")
    @Size(max = 16,message = "配件名称长度不能大于16")
    private String partsName;

    @ApiModelProperty(value = "配件编号")
    @NotBlank(message = "配件编号不能为空")
    @Size(max = 16,message = "配件编号长度不能大于16")
    private String partsNum;

    @ApiModelProperty(value = "配件备注")
    @Size(max = 64,message = "配件备注长度不能大于64")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPartsType() {
        return partsType;
    }

    public void setPartsType(Integer partsType) {
        this.partsType = partsType;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getPartsNum() {
        return partsNum;
    }

    public void setPartsNum(String partsNum) {
        this.partsNum = partsNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
