package biz.apollogames.eve.api.account;

import java.util.Date;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

@Root(strict = false)
public class AccountStatus extends BaseResponse {

    public static final String PATH = "/account/AccountStatus.xml.aspx";

    @Element @Path("result")
    public Date paidUntil;

    @Element @Path("result")
    public Date createDate;

    @Element @Path("result")
    public long logonCount;

    @Element @Path("result")
    public long logonMinutes;

    @Override
    public String toString() {
        return String.format("AccountStatus: paidUntil = %s", paidUntil);
    }
}
