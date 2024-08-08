package com.teladoc.framework.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({
  "file:${user.dir}/src/main/java/com/lean/framework/config/GlobalConfig.properties"
})
public interface GlobalConfig extends Config {

  String log4jPropertiesFile();

  String apiKey();

  String serverId();

  String serverDomain();
}
