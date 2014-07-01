package biz.apollogames.eve.api.character;

import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class AssetList extends BaseResponse {

    public static final String PATH = "/char/AssetList.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Item> assets;

    @Root(name = "row", strict = false)
    public static class Item {

        @Attribute public long itemID;

        @Attribute(required = false)
        public long locationID;

        @Attribute public long typeID;
        @Attribute public long quantity;

        @Attribute public int  flag;
        @Attribute public int  singleton;

        @ElementList(inline = true)
        @Path("rowset")
        public List<Item> contents;
    }
}
