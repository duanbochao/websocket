package com.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/26 17:09
 */
@Controller
public class WebSocketController {

    @MessageMapping("/welcome")  //那个请求/welcomel发来的
    @SendTo("/topic/getResponse") //发到那个订阅topic/getResponse
    public String getMessage(String name){
        System.out.println(name);
        return name;
    }
}
