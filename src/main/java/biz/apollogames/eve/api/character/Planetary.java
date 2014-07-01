package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class Planetary extends BaseResponse {

    public static final String COLONIES = "/char/PlanetaryColonies.xml.aspx";
    public static final String PINS     = "/char/PlanetaryPins.xml.aspx";
    public static final String ROUTES   = "/char/PlanetaryRoutes.xml.aspx";
    public static final String LINKS    = "/char/PlanetaryLinks.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Colony> colonies;

    @Root(name = "row")
    public static class Colony {

        @Attribute public long   planetID;
        @Attribute public long   planetTypeID;
        @Attribute public String planetTypeName;
        @Attribute public String planetName;
        @Attribute public long   solarSystemID;
        @Attribute public String solarSystemName;
        @Attribute public long   ownerID;
        @Attribute public String ownerName;
        @Attribute public Date   lastUpdate;
        @Attribute public int    upgradeLevel;
        @Attribute public int    numberOfPins;
    }

    public static class Pins extends BaseResponse {

        @ElementList(inline = true)
        @Path("result/rowset")
        public List<Pin> pins;
    }

    @Root(name = "row")
    public static class Pin {

        @Attribute public long      pinID;
        @Attribute public long      typeID;
        @Attribute public String    typeName;
        @Attribute public long      schematicID;
        @Attribute public Date      lastLaunchTime;
        @Attribute public int       cycleTime;
        @Attribute public int       quantityPerCycle;
        @Attribute public Date      installTime;
        @Attribute public Date      expiryTime;
        @Attribute public long      contentTypeID;
        @Attribute public String    contentTypeName;
        @Attribute public long      contentQuantity;
        @Attribute public float     longitude;
        @Attribute public float     latitude;
    }

    public static class Routes extends BaseResponse {

        @ElementList(inline = true)
        @Path("result/rowset")
        public List<Route> routes;
    }

    @Root(name = "row")
    public static class Route {
        @Attribute public long routeID;
        @Attribute public long sourcePinID;
        @Attribute public long destinationPinID;
        @Attribute public long contentTypeID;
        @Attribute public String contentTypeName;
        @Attribute public long quantity;
        @Attribute public long waypoint1;
        @Attribute public long waypoint2;
        @Attribute public long waypoint3;
        @Attribute public long waypoint4;
        @Attribute public long waypoint5;
    }

    public static class Links extends BaseResponse {

        @ElementList(inline = true)
        @Path("result/rowset")
        public List<Link> links;

    }

    @Root(name = "row")
    public static class Link {
        @Attribute public long sourcePinID;
        @Attribute public long destinationPinID;
        @Attribute public int linkLevel;
    }
}
