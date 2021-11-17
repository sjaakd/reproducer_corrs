package nl.reproducer.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path( "" )
public interface RestResource {

    @POST
    @Path( "/reproduce" )
    @Consumes( MediaType.APPLICATION_XML  )
    @Produces( MediaType.APPLICATION_JSON )
    @Operation(
        operationId = "example",
        summary = "Summary",
        description = "The Description"
    )
    @RequestBody(
        content = @Content(
            mediaType = MediaType.APPLICATION_XML,
            examples = {
                @ExampleObject(
                    name = "Arggh",
                    description = "Just a String",
                    value = "Just a String"
                )
            }
        )
    )
    @APIResponse(
        responseCode = "200",
        content = { @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema( implementation = nl.reproducer.resources.Response.class )
        ) },
        description = "The result."
    )
    Response register(String arg);
}
