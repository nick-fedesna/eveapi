package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class Mail extends BaseResponse {

    public static final String MESSAGES = "/char/MailMessages.xml.aspx";
    public static final String BODIES   = "/char/MailBodies.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Message> messages;

    @Root(name = "row")
    public static class Message {

        @Attribute public long   messageID;
        @Attribute public long   senderID;
        @Attribute public String senderName;
        @Attribute(required = false)
        public long   senderTypeID;

        @Attribute public Date   sentDate;
        @Attribute public String title;

        @Attribute(required = false) public String toCorpOrAllianceID;
        @Attribute(required = false) public String toCharacterIDs;
        @Attribute(required = false) public String toListID;
    }

    public static class Bodies extends BaseResponse {

        @Path("result/rowset")
        @ElementList(inline = true)
        public List<Body> bodies;

        @Path("result")
        @Element(required = false)
        public String missingMessageIDs;
    }

    @Root(name = "row")
    public static class Body {

        @Attribute public long messageID;

        @Text(data = true) public String message;
    }
}
