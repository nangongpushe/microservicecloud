package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

//这个注解就相当于spring里面的applicationContext.xml，可以理解为一旦加上了这个注解，
//就相当于把这个类当做了spring容器，这是springboot做的优化，springboot并不在提倡配置application.xml的这种做法
//因此直接使用一个类作为容器
@Configuration 
public class ConfigBean {
	
	@Bean
    @LoadBalanced	//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        return new RandomRule(); //使用我们重新选择的随机算法替代默认的轮询
//        return new RetryRule();
//    	return new RoundRobinRule();
    }
    
//    用来生成UserService的对象
//    @Bean
//    public UserService getUserService() {
//    	return new UserServiceImpl();
//    }
}
