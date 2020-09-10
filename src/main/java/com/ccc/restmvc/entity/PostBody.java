package com.ccc.restmvc.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "body",value = "参数体")
public class PostBody {

	@NotBlank
	@ApiModelProperty(required = true,value = "姓名",notes = "姓名",example = "Dick")
	private String name;
	
	@NotNull
	@Max(value = 100)
	@ApiModelProperty(required = true,value = "id",notes = "需要小于100",example = "99")
	private Integer id;
	
	@NotEmpty
	@NotNull
	@ApiModelProperty(required = true,value = "数据",notes = "不能为空",example = "[1,2,3]")
	private List<Integer> datas;
}
