//package com.muggle.poseidon.config;
//
//import com.muggle.poseidon.listener.ExceptionEvent;
//import com.muggle.poseidon.utils.DingUtils;
//import com.taobao.api.ApiException;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
///**
// * @Description:
// * @Author: muggle
// * @Date: 2020/6/8
// **/
//@Component
//public class ExceptionListener implements ApplicationListener<ExceptionEvent>  {
//    @Override
//    public void onApplicationEvent(ExceptionEvent event) {
//        try {
//            DingUtils.sendMessage("https://oapi.dingtalk.xxxxxxxxxxx/robot/send?access_token=83da62f0215f9e847b34a3d69e228e4ce7d0633a410a348419a772dc879fca71&timestamp=%s&sign=%s","SEC905b3a3849e9b438b15d2f17029e73b8bc23d942417ab3fb04f1f94d41270a41",event.getMessage());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//    }
//}
