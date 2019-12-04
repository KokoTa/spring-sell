package com.example.demo.mybatis;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Mybatis 生成器 GeneratorDisplay
 */
public class GeneratorDisplay {

  public void generator()
      throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
    List<String> warnings = new ArrayList<>();
    boolean overwrite = true;

    // 指定配置文件
    File configFile = new File("generatorConfig.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(configFile);
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    myBatisGenerator.generate(null);
  }

  public static void main(String[] args) {
    try {
      GeneratorDisplay generatorDisplay = new GeneratorDisplay();
      generatorDisplay.generator();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}