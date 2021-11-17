package nl.reproducer.resources;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

public class RestResourceImpl implements RestResource {

    private static final Logger LOG = Logger.getLogger( RestResourceImpl.class );

    public Response register(String arg) {
        LOG.debug( String.format( "register: %s", arg ) );
        return Response.ok().entity( "ok" ).type( MediaType.APPLICATION_XML ).build();
    }
}
