package biz.apollogames.eve.api;

import java.util.Date;

import org.simpleframework.xml.*;

@Root(name = "eveapi")
public class ErrorResponse {

    @Element public BaseResponse.Error error;

    @Attribute public String version;
    @Element public   Date   currentTime;
    @Element public   Date   cachedUntil;

}
