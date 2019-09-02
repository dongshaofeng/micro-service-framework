package cloud.oauth2.server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
//@Data
public class LoginHistory extends BaseDomain {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3503838536778480869L;
	private String clientId;
    private String username;
    public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	private String ip;
    private String device;
}
