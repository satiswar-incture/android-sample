package com.incture.sample.workbox.sample;

import com.incture.sample.workbox.models.UserWorkLoad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by satiswardash on 24/11/17.
 */

public class SampleDataProvider {

    public static ArrayList<UserWorkLoad> userWorkLoadList;
    public static Map<String, UserWorkLoad> userWorkLoadMap;

    static {
        userWorkLoadList = new ArrayList<>();
        userWorkLoadMap = new HashMap<>();

        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "Track_SLD", "Basis Copy user", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "7"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "saurabh", "Saurabh Raja", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "17"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "offboarding_hr", "HR", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "72"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "kdivya", "Divya K", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "1"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "inc00557", "Geetha Sridhar", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "9"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "RVATSYAYANA", "Rashmi VATSYAYANA", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "21"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "INC00427", "Amaresh Kolli", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "11"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "INC00668", "Rajarshi Datta", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "19"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "PKDAS", "Piyas Kumar Das", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "13"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "INC00589", "Ridhi Lamba", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "2"));
        addUserWorkLoadDataItem(
                new UserWorkLoad(null, "INC00666", "Subhasis Banerjee", "ZNWDI.Administrators, ZBPM Admin, NWDI.Administrators, Administrators, BPM ADMIN, PI Admin, SAP_XI_ADMINISTRATOR, Everyone, Authenticated Users", "2"));
    }

    private static void addUserWorkLoadDataItem(UserWorkLoad userWorkLoadItem){
        userWorkLoadList.add(userWorkLoadItem);
        //userWorkLoadMap.put(userWorkLoadItem.getWorkloadId(), userWorkLoadItem);
    }

}
