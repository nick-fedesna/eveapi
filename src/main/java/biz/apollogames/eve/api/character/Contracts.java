package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class Contracts extends BaseResponse {

    public static final String PATH = "/char/Contracts.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Contract> contracts;

    @Root(name = "row")
    public static class Contract {

        @Attribute public long    contractID;
        @Attribute public long    issuerID;
        @Attribute public long    issuerCorpID;
        @Attribute public long    assigneeID;
        @Attribute public long    acceptorID;
        @Attribute public long    startStationID;
        @Attribute public long    endStationID;
        @Attribute public String  type;
        @Attribute public String  status;
        @Attribute public String  title;
        @Attribute public boolean forCorp;
        @Attribute public String  availability;
        @Attribute public Date    dateIssued;
        @Attribute public Date    dateExpired;
        @Attribute public int     numDays;
        @Attribute public double  price;
        @Attribute public double  reward;
        @Attribute public double  collateral;
        @Attribute public double  buyout;
        @Attribute public double  volume;

        @Attribute(required = false)
        public Date dateAccepted;

        @Attribute(required = false)
        public Date dateCompleted;

        public Date getExpiration() {
            return new Date(dateIssued.getTime() + numDays * 86400000);
        }
    }

    public static class Items extends BaseResponse {

        public static final String PATH = "/char/ContractItems.xml.aspx";

        @ElementList(inline = true)
        @Path("result/rowset")
        public List<Item> items;
    }

    @Root(name = "row")
    public static class Item {

        @Attribute public long recordID;
        @Attribute public long typeID;
        @Attribute public long quantity;
        @Attribute public int  singleton;
        @Attribute public int  included;

        @Attribute(required = false)
        public long rawQuantity;

        @Override
        public String toString() {
            return String.format("Item: type=%d, qty=%d, raw=%d, single=%d, incl=%d",
                                 typeID, quantity, rawQuantity, singleton, included);
        }
    }
}
