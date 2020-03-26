package com.controller;

import com.bean.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/26 17:09
 */
@Controller
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")  //那个请求/welcomel发来的
    @SendTo("/topic/getResponse") //发到那个订阅topic/getResponse
    public String getMessage(String name){
      return name;
    }

//    @MessageMapping("/chat")
//    public void getChart(String name){
//       simpMessagingTemplate.convertAndSend("/topic/getResponse", name);
//   }



   @MessageMapping("/chat")
   public void chat(Principal principal, Chat chat){
        chat.setFrom(principal.getName());
       simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
   }

}
