package cloud.config;

import cloud.annotation.EnableDemoConfiguration;
import cloud.service.DemoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
@Configuration
@ConditionalOnBean(annotation = EnableDemoConfiguration.class)
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    DemoService demoService (){
        return new DemoService();
    }

}
