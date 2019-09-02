package cloud.service;

import cloud.config.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;

 
public class DemoService {

    @Autowired
    private DemoProperties demoProperties;

    public void print() {
        System.out.println(demoProperties.getName());
        System.out.println(demoProperties.getAge());
    }
}
