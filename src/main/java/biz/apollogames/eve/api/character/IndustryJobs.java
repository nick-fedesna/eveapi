package biz.apollogames.eve.api.character;

import java.util.Date;
import java.util.List;

import biz.apollogames.eve.api.BaseResponse;
import org.simpleframework.xml.*;

public class IndustryJobs extends BaseResponse {

    public static final String CURRENT = "/char/IndustryJobs.xml.aspx";
    public static final String HISTORY = "/char/IndustryJobsHistory.xml.aspx";

    @ElementList(inline = true, required = false)
    @Path("result/rowset")
    public List<NewJob> jobs;

    /*
    <result>
        <rowset name="jobs" key="jobID"
            columns="jobID,installerID,installerName,facilityID,solarSystemID,solarSystemName,stationID,
                activityID,blueprintID,blueprintTypeID,blueprintTypeName,blueprintLocationID,outputLocationID,
                runs,cost,teamID,licensedRuns,probability,productTypeID,productTypeName,status,timeInSeconds,
                startDate,endDate,pauseDate,completedDate,completedCharacterID" />
     */
    @Root(name = "row")
    public static class NewJob {

        @Attribute public long   jobID;
        @Attribute public long   installerID;
        @Attribute public String installerName;
        @Attribute public long   facilityID;
        @Attribute public long   solarSystemID;
        @Attribute public String solarSystemName;
        @Attribute public long   stationID;
        @Attribute public long   activityID;
        @Attribute public long   blueprintID;
        @Attribute public long   blueprintTypeID;
        @Attribute public String blueprintTypeName;
        @Attribute public long   blueprintLocationID;
        @Attribute public long   outputLocationID;
        @Attribute public long   runs;
        @Attribute public double cost;
        @Attribute public long   teamID;
        @Attribute public long   licensedRuns;
        @Attribute public double probability;
        @Attribute public long   productTypeID;
        @Attribute public String productTypeName;
        @Attribute public String status;
        @Attribute public long   timeInSeconds;
        @Attribute public Date   startDate;
        @Attribute public Date   endDate;
        @Attribute public Date   pauseDate;
        @Attribute public Date   completedDate;
        @Attribute public long   completedCharacterID;

        @Override
        public String toString() {
            return String.format("jobID=%d, product=%s, endTime=%s", jobID, productTypeName, endDate);
        }
    }


    @Deprecated
    @Root(name = "row")
    public static class Job {

        @Attribute public long   jobID;
        @Attribute public long   assemblyLineID;
        @Attribute public long   containerID;
        @Attribute public long   installedItemID;
        @Attribute public long   installedItemLocationID;
        @Attribute public long   installedItemQuantity;
        @Attribute public long   installedItemProductivityLevel;
        @Attribute public long   installedItemMaterialLevel;
        @Attribute public long   installedItemLicensedProductionRunsRemaining;
        @Attribute public long   outputLocationID;
        @Attribute public long   installerID;
        @Attribute public long   runs;
        @Attribute public long   licensedProductionRuns;
        @Attribute public long   installedInSolarSystemID;
        @Attribute public long   containerLocationID;
        @Attribute public double materialMultiplier;
        @Attribute public double charMaterialMultiplier;
        @Attribute public double timeMultiplier;
        @Attribute public double charTimeMultiplier;
        @Attribute public long   installedItemTypeID;
        @Attribute public long   outputTypeID;
        @Attribute public long   containerTypeID;
        @Attribute public long   installedItemCopy;
        @Attribute public long   completed;
        @Attribute public long   completedSuccessfully;
        @Attribute public long   installedItemFlag;
        @Attribute public long   outputFlag;
        @Attribute public long   activityID;
        @Attribute public long   completedStatus;
        @Attribute public Date   installTime;
        @Attribute public Date   beginProductionTime;
        @Attribute public Date   endProductionTime;
        @Attribute public Date   pauseProductionTime;

        @Override
        public String toString() {
            return String.format("jobID=%d, itemID=%d, endTime=%s", jobID, installedItemID, endProductionTime);
        }
    }

    public static class History {

        @ElementList(inline = true, required = false)
        @Path("result/rowset")
        public List<NewJob> jobs;

    }

}
