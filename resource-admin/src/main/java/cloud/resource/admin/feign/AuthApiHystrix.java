package cloud.resource.admin.feign;

import org.springframework.stereotype.Service;

@Service
public class AuthApiHystrix implements AuthApi {

	public String getToken() {
		System.out.println("调用{}异常:{}");
		return "调用{}异常:{}";
	}
}
