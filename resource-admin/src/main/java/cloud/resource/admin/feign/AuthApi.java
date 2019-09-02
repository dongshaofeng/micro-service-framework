package cloud.resource.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cloud-oauth2-server", fallback = AuthApiHystrix.class)
public interface AuthApi {
 
	@RequestMapping(method = RequestMethod.POST, value = "/oauth/token")
	String getToken();
}