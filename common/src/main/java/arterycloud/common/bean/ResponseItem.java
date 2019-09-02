package arterycloud.common.bean;

import io.swagger.annotations.ApiModelProperty;

public class ResponseItem<T> {
	@ApiModelProperty(value = "响应信息签名 ",dataType = "String")
    private  String sign;
	
	@ApiModelProperty(value = "响应信息签名算法类型",dataType = "String")
    private  String signType;
	
	@ApiModelProperty(value = "响应消息体内容，私有值对象",dataType = "T")
	private T data;
	
    @ApiModelProperty(value = "响应代码",dataType = "int")
	private String code;
    
    @ApiModelProperty(value = "响应消息描述",dataType = "String")
	private String message;
 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	 
	
	

}
