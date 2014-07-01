package biz.apollogames.eve.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.simpleframework.xml.*;
import org.simpleframework.xml.transform.Transform;

@Root(name = "eveapi")
public abstract class BaseResponse {

    public static final DateFormat      DATE_FORMAT      = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final Transform<Date> DATE_TRANSFORMER = new Transform<Date>() {
        public Date read(String value) throws Exception {
            return isEmpty(value) ? null : DATE_FORMAT.parse(value);
        }

        public String write(Date value) throws Exception {
            return DATE_FORMAT.format(value);
        }
    };

    static {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Attribute public String version;
    @Element public   Date   currentTime;
    @Element public   Date   cachedUntil;

    @Element(required = false)
    public Error error;

    @Attribute(required = false)
    @Path("result/rowset")
    public String name;

    @Attribute(required = false)
    @Path("result/rowset")
    public String key;

    @Attribute(required = false)
    @Path("result/rowset")
    public String[] columns;

    public static class Error {

        @Attribute public long   code;
        @Text      public String message;
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
