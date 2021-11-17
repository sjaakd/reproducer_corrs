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

import static io.vertx.core.http.HttpHeaders.ACCEPT;

import io.quarkus.vertx.web.RouteFilter;
import io.vertx.ext.web.RoutingContext;

public class OpenApiAsJsonFilter {

    @RouteFilter
    public void modifyAcceptHeader(RoutingContext rc) {
        String url = rc.normalizedPath();
        if ( url.endsWith( "openapi.json" ) ) {
            String acceptHeader = rc.request().headers().get( ACCEPT );
            if ( acceptHeader != null && !acceptHeader.contains( "yaml" ) ) {
                rc.request().headers().set( ACCEPT, "application/json" );
            }
            rc.reroute(  url.substring( 0, url.lastIndexOf( '.' ) ) );
            return;
        }
        else if ( url.endsWith( "openapi.yaml" ) ) {
            rc.reroute(  url.substring( 0, url.lastIndexOf( '.' ) ) );
            return;
        }
        rc.next();
    }
}
