package com.teladoc.framework.utilities;


import com.teladoc.framework.config.GlobalConfigReader;
import com.teladoc.framework.helper.CucumberHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import static org.apache.logging.log4j.core.config.Configurator.initialize;

public class LogUtil {

  private LogUtil() {
    throw new IllegalStateException("LogUtil class");
  }

  private static Logger log = LogManager.getLogger(LogUtil.class);

  public static void info(String message) {
    ThreadContext.put("scenarioName", CucumberHelper.getScenario());
    log.info(message);
  }

  public static void info(String marker, String message) {
    ThreadContext.put("scenarioName", CucumberHelper.getScenario());
    log.info(marker, message);
  }

  public static void setLogger() {
    try {
      final var Path_Log4jConfiguraton = GlobalConfigReader.getProperty().log4jPropertiesFile();
      initialize(null, Path_Log4jConfiguraton);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
