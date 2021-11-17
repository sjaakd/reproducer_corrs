/*
 * Copyright TNO Geologische Dienst Nederland
 *
 * Alle rechten voorbehouden.
 * Niets uit deze software mag worden vermenigvuldigd en/of openbaar gemaakt door middel van druk, fotokopie,
 * microfilm of op welke andere wijze dan ook, zonder voorafgaande toestemming van TNO.
 *
 * Indien deze software in opdracht werd uitgebracht, wordt voor de rechten en verplichtingen van opdrachtgever
 * en opdrachtnemer verwezen naar de Algemene Voorwaarden voor opdrachten aan TNO, dan wel de betreffende
 * terzake tussen de partijen gesloten overeenkomst.
 */
package nl.reproducer.vertx;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.quarkus.vertx.web.RouteFilter;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class ApiVersionResponseFilter {

    private static final String API_VERSION_HEADER = "API-Version";

    //CHECKSTYLE:OFF
    @Inject
    ConfigProvider provider;
    //CHECKSTYLE:ON

    @RouteFilter
    public void addResponse(RoutingContext rc) {
            rc.response().headers().set( API_VERSION_HEADER,  provider.version  );
        rc.next();
    }

    @Dependent
    public static class ConfigProvider {

        //CHECKSTYLE:OFF
        @ConfigProperty( name = "application.version" )
        String version;
        //CHECKSTYLE:ON

    }
}
