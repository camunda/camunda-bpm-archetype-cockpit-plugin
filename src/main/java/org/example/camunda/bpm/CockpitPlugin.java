package org.example.camunda.bpm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.camunda.bpm.resources.CockpitPluginRootResource;
import org.camunda.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

public class CockpitPlugin extends AbstractCockpitPlugin {

  public static final String ID = "cockpit-plugin";

  public String getId() {
    return ID;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(CockpitPluginRootResource.class);

    return classes;
  }

  @Override
  public List<String> getMappingFiles() {
    return Arrays.asList("org.example.camunda.bpm".replace(".", "/") + "/cockpit-plugin-query.xml");
  }
}
