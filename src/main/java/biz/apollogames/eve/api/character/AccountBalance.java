package biz.apollogames.eve.api.character;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

@Root(strict = false)
public class AccountBalance extends BaseResponse {

    public static final String PATH = "/char/AccountBalance.xml.aspx";

    @Attribute
    @Path("result/rowset/row")
    public long accountID;

    @Attribute
    @Path("result/rowset/row")
    public long accountKey;

    @Attribute
    @Path("result/rowset/row")
    public double balance;


}
