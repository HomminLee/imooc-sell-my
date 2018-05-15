package com.hommin.study.imoocsell.sevice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * websocket
 *
 * @author Hommin
 * 2018年05月14日 下午9:17
 */
@Component
@ServerEndpoint("/seller/websocket")
@Slf4j
public class WebSocketService {

    private Session session;

    private static Set<WebSocketService> set = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        set.add(this);
        log.info("有新连接加入！当前在线人数为={}", set.size());
    }

    @OnClose
    public void onClose(Session session){
        set.remove(this);
        log.info("有连接关闭！当前在线人数为={}", set.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("收到来自客户端的消息, message={}", message);
    }

    public void sendMessage(String message){
        for (WebSocketService webSocketService : set) {
            try {
                webSocketService.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
