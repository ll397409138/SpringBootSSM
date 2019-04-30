package com.carapp.carscrapordermanager.common;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class PageResult<T> {
	
	 @ApiModelProperty(value = "数据总结果数")
	  private Long total;
	 @ApiModelProperty(value = "当前请求每页显示数据条数")
	  private List<?> rows;
	  
	  public PageResult() {

	    }

	 public PageResult(Long total, List<?> rows) {
	        this.total = total;
	        this.rows = rows;
	    }

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
