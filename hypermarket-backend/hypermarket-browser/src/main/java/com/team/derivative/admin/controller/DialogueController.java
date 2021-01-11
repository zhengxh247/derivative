package com.team.derivative.admin.controller;

import com.team.derivative.admin.service.DialogueService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/dialogue")
@Api(tags = {"对话管理"}, description = "dialogue")
public class DialogueController {

    /**
     * 群发消息内容
     *
     * @param message
     * @return
     */
    @GetMapping(value = "/sendAll")
    public String sendAllMessage(@RequestParam(required = true) String message) {
        try {
            DialogueService.BroadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     * @param id      连接会话ID
     * @return
     */
    @GetMapping(value = "/sendOne")
    public String sendOneMessage(@RequestParam(required = true) String message, @RequestParam(required = true) String id) {
        try {
            DialogueService.SendMessage(message, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
