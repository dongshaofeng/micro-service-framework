package arterycloud.common.bean;

import io.swagger.annotations.ApiModel;

@ApiModel("测试值对象")
public class Filter {

	//字段名称
	private String column;
	//字段内容
	private String value;
	//字段
	private String filterType;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

}