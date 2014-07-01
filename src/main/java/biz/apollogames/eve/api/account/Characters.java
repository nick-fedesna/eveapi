package biz.apollogames.eve.api.account;

import java.util.List;

import biz.apollogames.eve.api.BaseCharacter;
import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

@Root(strict = false)
public class Characters extends BaseResponse {

    public static final String PATH = "/account/Characters.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Character> characters;

    @Root(name = "row")
    public static class Character extends BaseCharacter {

        @Attribute public String name;

        @Override
        public String toString() {
            return String.format("Character: %s [%s] {%s}", name, corporationName, allianceName);
        }
    }
}
