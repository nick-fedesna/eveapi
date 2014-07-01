package biz.apollogames.eve.api;

import org.simpleframework.xml.Attribute;

public abstract class BaseCharacter {

    @Attribute public long   characterID;
    @Attribute public long   corporationID;
    @Attribute public long   allianceID;
    @Attribute public long   factionID;

//    public String characterName;
    @Attribute public String corporationName;

    @Attribute(required = false) public String allianceName;
    @Attribute(required = false) public String factionName;
}
