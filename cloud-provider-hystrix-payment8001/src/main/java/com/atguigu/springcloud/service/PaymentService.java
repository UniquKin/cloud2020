package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：\t"+Thread.currentThread().getName()+"\tpaymentInfo_OK,id:\t"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int age = 10/0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：\t"+Thread.currentThread().getName()+"\tid:\t"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时：";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：\t"+Thread.currentThread().getName()+"\t8001系统繁忙或者运行报错，请稍后再试,id:\t"+id+"\t"+"/(ㄒoㄒ)/~~";
    }
}
