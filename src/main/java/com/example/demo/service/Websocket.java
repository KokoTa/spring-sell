package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@Component
@ServerEndpoint("/websocket")
@Slf4j
public class Websocket {

    private Session session;

    private static CopyOnWriteArraySet<Websocket> websockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websockets.add(this);
        log.info("[Websocket]：有新连接, 总数={}", websockets.size());
    }

    @OnClose
    public void onClose() {
        websockets.remove(this);
        log.info("[Websocket]：连接断开, 总数={}", websockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[Websocket]：收到消息, 消息={}", message);
    }

    public void sendMessage(String message) {
        for (Websocket websocket: websockets) {
            log.info("[Websocket]: 广播消息, message={}", message);

            try {
                websocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
