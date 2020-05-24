package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    /**
     * RT设定值是处理时间
     * RT默认是1秒5个线程处理时间是设定的RT值。这两个全部未达标会访问失败
     * JMeter设置1秒10个线程，RT设置的值是200毫秒所以会报错
     * @return
     */
    @GetMapping("/testD")
    public String testD(){
        //暂停几秒钟线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

}
