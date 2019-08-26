package cn.ffcs.tsp.controller.manual;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/** 
 * 处理平台的时间转换 
 * @author alf 
 * 2011-8-31 上午09:21:39 
 */  
public class DateHandler {  
    private static Calendar calS=Calendar.getInstance();  
    /** 
     * 计算剩余时间 
     * @param startDateStr 
     * @param endDateStr 
     * @return 
     */  
    public static String remainDateToString(String startDateStr, String endDateStr){  
        java.util.Date startDate = null;  
        java.util.Date endDate= null;  
        try {  
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);  
        } catch (ParseException e) {  
            e.printStackTrace();  
            return "";  
        }  
        try {  
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);  
        } catch (ParseException e) {  
            e.printStackTrace();  
            return "";  
        }  
        calS.setTime(startDate);  
        int startY = calS.get(Calendar.YEAR);  
        int startM = calS.get(Calendar.MONTH);  
        int startD = calS.get(Calendar.DATE);  
        int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);  
          
        calS.setTime(endDate);  
        int endY = calS.get(Calendar.YEAR);  
        int endM = calS.get(Calendar.MONTH);  
        //处理2011-01-10到2011-01-10，认为服务为一天  
        int endD = calS.get(Calendar.DATE);  
        int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);  
          
        StringBuilder sBuilder = new StringBuilder();  
        if (endDate.compareTo(startDate)<=0) {  
            return sBuilder.append("0天").toString();  
        }  
        int lday = endD-startD;  
        if (lday<0) {  
            endM = endM -1;  
            lday = startDayOfMonth+ lday;  
        }  
        //处理天数问题，如：2011-01-01 到 2013-12-31  2年11个月31天     实际上就是3年  
        if (lday == endDayOfMonth) {  
            endM = endM+1;  
            lday =0;  
        }  
        int mos = (endY - startY)*12 + (endM- startM);  
        int lyear = mos/12;  
        int lmonth = mos%12;  
        if (lyear >0) {  
            sBuilder.append(lyear+"年");  
        }  
        if (lmonth > 0) {  
            sBuilder.append(lmonth+"个月");  
        }  
        if (lday >0 ) {  
            sBuilder.append(lday+"天");  
        }  
        if(lyear >20){
        	sBuilder = new StringBuilder();  
        	sBuilder.append("无限期");  
        }
        return sBuilder.toString();  
    }  
      
    public static void main(String[] args) {  
        System.out.println(remainDateToString("2019-07-10", "2119-07-11"));  
    }  
}  