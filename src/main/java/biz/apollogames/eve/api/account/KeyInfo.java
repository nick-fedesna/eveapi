package biz.apollogames.eve.api.account;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseCharacter;
import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;
import timber.log.Timber;

@Root(strict = false)
public class KeyInfo extends BaseResponse {

    public static final String PATH = "/account/APIKeyInfo.xml.aspx";

    @Attribute
    @Path("result/key")
    public long accessMask;

    @Attribute
    @Path("result/key")
    public String type;

    @Attribute(required = false)
    @Path("result/key")
    public Date expires;

    @ElementList(inline = true)
    @Path("result/key/rowset")
    public List<Character> characters;

    @Root(name = "row")
    public static class Character extends BaseCharacter {
        @Attribute public String characterName;
    }

	@Override
	public String toString() {
        return String.format("ApiKeyInfo: type=%s, mask=%d, expires=%s, ", type, accessMask, expires);
	}
	
	
}
