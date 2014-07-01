package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseCharacter;
import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

@Root(strict = false)
public class KillLog extends BaseResponse {

    public static final String PATH = "/char/KillMails.xml.aspx";

    @ElementList(inline = true, required = false)
    @Path("result/rowset")
    public List<Kill> kills;

    //      <row killID="63" solarSystemID="30000848" killTime="2007-11-15 15:36:00" moonID="0">
    @Root(name = "row")
    public static class Kill {

        @Attribute public long killID;
        @Attribute public Date killTime;
        @Attribute public long solarSystemID;
        @Attribute public long moonID;

        @Element public Victim victim;

        @ElementList(inline = true)
        @Path("rowset[1]")
        public List<Attacker> attackers;

        @ElementList(inline = true, required = false)
        @Path("rowset[2]")
        public List<Item> items;

    }

    public static class Victim extends BaseCharacter {

        @Attribute public String characterName;
        @Attribute public long shipTypeID;
        @Attribute public long damageTaken;
    }

    public static class Attacker extends BaseCharacter {

        @Attribute public double  securityStatus;
        @Attribute public long    weaponTypeID;
        @Attribute public long    shipTypeID;
        @Attribute public long    damageDone;
        @Attribute public boolean finalBlow;

    }

//    <rowset name="items" columns="typeID,flag,qtyDropped,qtyDestroyed,singleton" />

    @Root(name = "row")
    public static class Item {

        @Attribute public long typeID;
        @Attribute public long qtyDropped;
        @Attribute public long qtyDestroyed;
        @Attribute public int singleton;
        @Attribute public int flag;

        @ElementList(inline = true, required = false)
        @Path("rowset")
        public List<Item> contents;

    }
}
