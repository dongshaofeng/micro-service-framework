package cloud.resource.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2resourceserver
 */
@EnableTransactionManagement
@SpringBootApplication
//@EnableFeignClients
public class ResourceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceAdminApplication.class, args);
    }
}
