/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import business.domainClasses.AccountLog;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 727153
 */
public class ReportUtil {
    
    public static String prepareData(List<AccountLog> logs) {
        List<DataPoint> dataPoints = new ArrayList<DataPoint>();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date dateToCompare = logs.get(0).getActivityDate();
        int count = 0;
        for (AccountLog log : logs) {
            Date logDate = log.getActivityDate();
            if (fmt.format(logDate).equals(fmt.format(dateToCompare))) {
                count++;
            } else {
                DataPoint dataPoint = new DataPoint(count, dateToCompare);
                dataPoints.add(dataPoint);
                dateToCompare = logDate;
                count = 1;
            }
        }
        return new Gson().toJson(dataPoints);
        
    }
    
    private static class DataPoint {
        private int count;
        private Date date;

        public DataPoint(int count, Date date) {
            this.count = count;
            this.date = date;
        }
    }
}
