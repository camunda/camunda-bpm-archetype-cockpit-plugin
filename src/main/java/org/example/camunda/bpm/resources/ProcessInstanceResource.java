package org.example.camunda.bpm.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginResource;

import org.example.camunda.bpm.db.ProcessInstanceCountDto;

public class ProcessInstanceResource extends AbstractCockpitPluginResource {

  public ProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ProcessInstanceCountDto> getProcessInstanceCounts() {

    return getQueryService()
        .executeQuery(
          "org.example.camunda.bpm.selectProcessInstanceCountsByProcessDefinition",
          new QueryParameters<ProcessInstanceCountDto>());
  }
}
