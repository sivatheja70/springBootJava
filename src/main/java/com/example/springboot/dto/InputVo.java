package com.example.springboot.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InputVo {
	@NotNull
	private String startDate;
	@NotNull
	private String endDate;
	@Min(value=10000)
	@NotNull
	private String minSal;
	@Min(value=200000)
	@NotEmpty(message=" Max Sal should not be empty")
	private String maxSal;
	
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getMinSal() {
		return minSal;
	}
	public void setMinSal(String minSal) {
		this.minSal = minSal;
	}
	public String getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(String maxSal) {
		this.maxSal = maxSal;
	}
	
	
}
