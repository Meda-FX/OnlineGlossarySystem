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
 * Report class is to
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class ReportUtil {
/**
 * 
 * @param logs
 * @return 
 */
    public static String prepareData(List<AccountLog> logs) {
        List<DataPoint> dataPoints = new ArrayList<DataPoint>();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String dateToCompare = fmt.format(logs.get(0).getActivityDate());
        int count = 0;
        for (int i = 0; i < logs.size(); i++) {
            Date logDate = logs.get(i).getActivityDate();
            if (fmt.format(logDate).equals(dateToCompare)) {
                count++;
                
            } else {
                DataPoint dataPoint = new DataPoint(count, dateToCompare);
                dataPoints.add(dataPoint);
                dateToCompare = fmt.format(logDate);
                count = 1;
            }
            if (i == logs.size() - 1) {
                DataPoint dataPoint = new DataPoint(count, dateToCompare);
                dataPoints.add(dataPoint);
            }
        }
        return new Gson().toJson(dataPoints);

    }
/**
 * 
 */
    private static class DataPoint {

        private int count;
        private String date;

        public DataPoint(int count, String date) {
            this.count = count;
            this.date = date;
        }
    }
}
