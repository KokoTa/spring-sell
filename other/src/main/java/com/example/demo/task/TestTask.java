package com.example.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TestTask
 */
@Component
public class TestTask {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /**
   * 定时任务
   */
  
  // 定义每 3s 执行一次任务
  // @Scheduled(fixedRate = 3000)
  @Scheduled(cron = "1-10 * * * * ?") // http://qqe2.com/cron
  public void reportCurrentTime() {
    System.out.println(dateFormat.format(new Date()));
  }

  /**
   * 异步任务
   * 一般用于发送短信、发送邮件、App消息推送
   * @throws InterruptedException
   */

  @Async
  public Future<Boolean> syncMethod1() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread.sleep(1000);
    long end = System.currentTimeMillis();

    System.out.println(end - start);

    return new AsyncResult<>(true);
  }

  @Async
  public Future<Boolean> syncMethod2() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread.sleep(500);
    long end = System.currentTimeMillis();

    System.out.println(end - start);

    return new AsyncResult<>(true);
  }
}