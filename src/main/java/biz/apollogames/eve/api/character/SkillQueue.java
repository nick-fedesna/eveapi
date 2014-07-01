package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class SkillQueue extends BaseResponse {

    public static final String PATH     = "/char/SkillQueue.xml.aspx";
    public static final String TRAINING = "/char/SkillInTraining.xml.aspx";

    @ElementList(inline = true, required = false)
    @Path("result/rowset")
    public List<Skill> skills;

    @Root(name = "row")
    public static class Skill {

        @Attribute public int  queuePosition;
        @Attribute public long typeID;
        @Attribute public int  level;
        @Attribute public int  startSP;
        @Attribute public int  endSP;
        @Attribute public Date startTime;
        @Attribute public Date endTime;


    }
    /*
    <result>
        <rowset name="skillqueue" key="queuePosition"
            columns="queuePosition,typeID,level,startSP,endSP,startTime,endTime">
          <row queuePosition="1" typeID="11441" level="3" startSP="7072" endSP="40000" startTime="2009-03-18 02:01:06" endTime="2009-03-18 15:19:21" />
          <row queuePosition="2" typeID="20533" level="4" startSP="112000" endSP="633542" startTime="2009-03-18 15:19:21" endTime="2009-03-30 03:16:14" />
        </rowset>
    </result>
     */

    public static class Training extends BaseResponse {

        @Element(required = false)
        @Path("result")
        public Date currentTQTime;

//        @Attribute(required = false)
//        @Path("result/currentTQTime")
//        public int offset;

        @Element(required = false)
        @Path("result")
        public Date trainingEndTime;

        @Element(required = false)
        @Path("result")
        public Date trainingStartTime;

        @Element(required = false)
        @Path("result")
        public long trainingTypeID;

        @Element(required = false)
        @Path("result")
        public int trainingStartSP;

        @Element(required = false)
        @Path("result")
        public int trainingDestinationSP;

        @Element(required = false)
        @Path("result")
        public int trainingToLevel;

        @Element()
        @Path("result")
        public int skillInTraining;

    }

    /*
    <result>
        <currentTQTime offset="0">2008-08-17 06:43:00</currentTQTime>
        <trainingEndTime>2008-08-17 15:29:44</trainingEndTime>
        <trainingStartTime>2008-08-15 04:01:16</trainingStartTime>
        <trainingTypeID>3305</trainingTypeID>
        <trainingStartSP>24000</trainingStartSP>
        <trainingDestinationSP>135765</trainingDestinationSP>
        <trainingToLevel>4</trainingToLevel>
        <skillInTraining>1</skillInTraining>
    </result>
     */
}
