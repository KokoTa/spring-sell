package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * LoggerTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

  @Test
  public void test() {
    String name = "KokoTa";
    String age = "24";

    log.debug("debug...");
    log.info("name: {}, age: {}", name, age);
    log.error("error...");
    log.warn("warn...");
  }
}