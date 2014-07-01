package biz.apollogames.eve.api.eve;

import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class TypeName extends BaseResponse {

    public static final String PATH = "/eve/TypeName.xml.aspx";

    @ElementList(inline = true)
    @Path("result/rowset")
    public List<Type> types;

    @Root(name = "row")
    public static class Type {

        @Attribute public long   typeID;
        @Attribute public String typeName;
    }
}
