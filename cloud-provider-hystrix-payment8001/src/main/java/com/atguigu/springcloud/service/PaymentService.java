package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：\t"+Thread.currentThread().getName()+"\tpaymentInfo_OK,id:\t"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            Thread.sleep(timeNumber*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：\t"+Thread.currentThread().getName()+"\tpaymentInfo_TimeOut,id:\t"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时："+timeNumber;
    }
}
