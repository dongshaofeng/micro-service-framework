package cloud.oauth2.server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;

import java.util.Date;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
//@Data
public class Role extends BaseDomain {
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String roleName;
}
