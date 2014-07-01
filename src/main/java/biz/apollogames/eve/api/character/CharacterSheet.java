package biz.apollogames.eve.api.character;

import java.util.*;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

@Root(strict = false)
public class CharacterSheet extends BaseResponse {

    public static final String PATH = "/char/CharacterSheet.xml.aspx";

    @Element @Path("result") public long   characterID;

    @Element @Path("result") public String name;
    @Element @Path("result") public Date   DoB;
    @Element @Path("result") public String race;
    @Element @Path("result") public String bloodLine;
    @Element @Path("result") public String ancestry;
    @Element @Path("result") public String gender;

    @Element @Path("result") public long   corporationID;
    @Element @Path("result") public String corporationName;

    @Element(required = false) @Path("result") public long   allianceID;
    @Element(required = false) @Path("result") public String allianceName;

    @Element(required = false) @Path("result") public long   factionID;
    @Element(required = false) @Path("result") public String factionName;

    @Element @Path("result") public String cloneName;
    @Element @Path("result") public long   cloneSkillPoints;
    @Element @Path("result") public double balance;

    @Path("result")
    @Element(name = "attributeEnhancers")
    Implants implants;

    @Root
    public static class Implants {

        @Element MemoryBonus       memoryBonus;
        @Element PerceptionBonus   perceptionBonus;
        @Element WillpowerBonus    willpowerBonus;
        @Element IntelligenceBonus intelligenceBonus;
        @Element CharismaBonus     charismaBonus;
    }

    @Root public static class MemoryBonus extends Augmentor {}
    @Root public static class PerceptionBonus extends Augmentor {}
    @Root public static class WillpowerBonus extends Augmentor {}
    @Root public static class IntelligenceBonus extends Augmentor {}
    @Root public static class CharismaBonus extends Augmentor {}

    static class Augmentor {
        @Element String augmentatorName;
        @Element int augmentatorValue;
    }

    @Path("result") @Element Attributes attributes;

    public static class Attributes {
        @Element int intelligence;
        @Element int memory;
        @Element int charisma;
        @Element int perception;
        @Element int willpower;
    }

    @Path("result[1]/rowset[1]")
    @ElementList(inline = true, required = false)
    List<Skill> skills;

    @Root(name = "row")
    static class Skill {
        @Attribute long    typeID;
        @Attribute int     skillpoints;
        @Attribute int     level;
        @Attribute boolean published;
    }

    @Path("result[1]/rowset[2]")
    @ElementList(inline = true, required = false)
    List<Certificate> certificates;

    public static class Certificate {
        @Attribute public int certificateID;
    }

    @Path("result[1]/rowset[3]")
    @ElementList(inline = true, required = false)
    List<Role> corporationRoles;

    @Path("result[1]/rowset[4]")
    @ElementList(inline = true, required = false)
    List<Role> corporationRolesAtHQ;

    @Path("result[1]/rowset[5]")
    @ElementList(inline = true, required = false)
    List<Role> corporationRolesAtBase;

    @Path("result[1]/rowset[6]")
    @ElementList(inline = true, required = false)
    List<Role> corporationRolesAtOther;

    public static class Role {
        @Attribute public long   roleID;
        @Attribute public String roleName;
    }

    @Path("result[1]/rowset[7]")
    @ElementList(inline = true, required = false)
    List<Title> corporationTitles;

    public static class Title {
        @Attribute public long titleID;
        @Attribute public String titleName;
    }


}
