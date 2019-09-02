package arterycloud.common.bean;

import io.swagger.annotations.ApiModelProperty;

public class RequestItem<T> {
	@ApiModelProperty(value = "请求信息签名 ",dataType = "String")
    private  String sign;
	
	@ApiModelProperty(value = "请求信息签名算法类型",dataType = "String")
    private  String signType;
	
	@ApiModelProperty(value = "请求消息体内容，私有值对象",dataType = "T")
	private T data;
	
	@ApiModelProperty(value = "令牌",dataType = "String")
    private  String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
