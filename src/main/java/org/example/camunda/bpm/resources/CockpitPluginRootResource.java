package org.example.camunda.bpm.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginRootResource;

import org.example.camunda.bpm.CockpitPlugin;

@Path("plugin/" + CockpitPlugin.ID)
public class CockpitPluginRootResource extends AbstractCockpitPluginRootResource {

  public CockpitPluginRootResource() {
    super(CockpitPlugin.ID);
  }

  @Path("{engineName}/process-instance")
  public ProcessInstanceResource getProcessInstanceResource(@PathParam("engineName") String engineName) {
    return subResource(new ProcessInstanceResource(engineName), engineName);
  }
}
