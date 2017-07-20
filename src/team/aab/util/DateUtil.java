package team.aab.util;

/**
 * @descript DateUtil.java
 * @author 
 * @version 1.0
 * @date Mar 2, 2010
 * @company:hundsun
 */

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author admin
 */
public class DateUtil {
    private static final String sdf1reg = "^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$";

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    private static final String sdf2reg = "^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2}$";

    private static final SimpleDateFormat sdf2 = new SimpleDateFormat(
            "yyyy-MM-dd");

    private static final String sdf3reg = "^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$";

    private static final SimpleDateFormat sdf3 = new SimpleDateFormat(
            "yyyy/MM/dd HH:mm:ss");

    private static final String sdf4reg = "^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2}$";

    private static final SimpleDateFormat sdf4 = new SimpleDateFormat(
            "yyyy/MM/dd");

    private static final String sdf5reg = "^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}$";

    private static final SimpleDateFormat sdf5 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");

    private static final String sdf6reg = "^\\d{2,4}\\d{1,2}\\d{1,2}$";
    
    private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyyMMdd");

    /**
     * 将Timestamp类型转换字符串(yyyyMMddHHmmss)
     *
     * @param date
     * @return
     */
    public static String getStringTimestampE(Timestamp date) {
        if(date == null){
        	return " ";
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);

        return str;
    }

    /**
     * <p/> 将日期格式化成相应格式的字符串，如：
     * <li>yyyy-MM-dd HH:mm:ss
     * <li>yyyy-MM-dd
     * <li>yyyy/MM/dd HH:mm:ss
     * <li>yyyy/MM/dd
     * </p>
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null){
            return " ";
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将Timestamp类型转换成字符串（yyyyMMdd）
     *
     * @param date
     * @return
     */
    public static String getStringTimestamp1(Timestamp date) {
        if(date == null){
        	return " ";
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);

        return str;
    }

    /**
     * 将DATE类型转换成字符串（yyyyMMdd）
     *
     * @param date
     * @return
     */
    public static String getStringDate1(Date date) {
        if(date == null){
        	return " ";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);

        return str;
    }

    public String getStringTimestampDelSlash(Timestamp date) {

        if (date == null) {
            return " ";
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);
        str = str.substring(0, 4) + str.substring(5, 7) + str.substring(8);

        return str;
    }

    /**
     * 取得Calendar实例
     *
     * @return
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 根据日期偏移天数取得日期。offset > 0 ,往后延迟offset天， offset < 0 向前推进 offset天
     *
     * @param date:基日期
     * @param offset:日期天数偏移量
     * @return
     */
    public static Date getDate(Date date, int offset) {
        if (date == null){
            return date;
        }
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, offset);
        return calendar.getTime();
    }


    /**
     * <p/> 将日期字符串解析成日期对象，支持一下格式
     * <li>yyyy-MM-dd HH:mm:ss
     * <li>yyyy-MM-dd
     * <li>yyyy/MM/dd HH:mm:ss
     * <li>yyyy/MM/dd
     * </p>
     *
     * @param str
     * @return
     */
    public static Date parse(String str) {
        Date date = null;
        Pattern p1 = Pattern.compile(sdf1reg);
        Matcher m1 = p1.matcher(str);
        Pattern p2 = Pattern.compile(sdf2reg);
        Matcher m2 = p2.matcher(str);
        Pattern p3 = Pattern.compile(sdf3reg);
        Matcher m3 = p3.matcher(str);
        Pattern p4 = Pattern.compile(sdf4reg);
        Matcher m4 = p4.matcher(str);
        Pattern p5 = Pattern.compile(sdf5reg);
        Matcher m5 = p5.matcher(str);
        Pattern p6 = Pattern.compile(sdf6reg);
        Matcher m6 = p6.matcher(str);
        try {
            if (m1.matches()) {
                date = sdf1.parse(str);
            } else if (m2.matches()) {
                date = sdf2.parse(str);
            } else if (m3.matches()) {
                date = sdf3.parse(str);
            } else if (m4.matches()) {
                date = sdf4.parse(str);
            } else if (m5.matches()) {
                date = sdf5.parse(str);
            } else if (m6.matches())
                date = sdf6.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException("非法日期字符串，解析失败：" + str, e);
        }
        return date;
    }
    
	/**
	 * 获取系统时间 yyyyMMddHHmmss
	 * @return
	 */
	public static String nowTime(){
	    String dateStr = "";
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		dateStr=format.format(new Date(System.currentTimeMillis()));
	
		return dateStr;
	}
	
	/**
	 * 获取系统时间 yyyyMMdd
	 * @return
	 */
	public static String nowDate(){
	    String dateStr = "";
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
		dateStr=format.format(new Date(System.currentTimeMillis()));
	
		return dateStr;
	}
	
	/**
	 * 获取昨日
	 * @return
	 */
	public static String yesTodate(){
		String dateStr = "";
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
		dateStr=format.format(getDate(new Date(),-1));
		
		return dateStr;
	}
	
	
	/**
	 * 获取当时时间 HHMMSS
	 * @return
	 */
	public static String nowTimeHms(){
		String hms = nowTime().substring(8);
	
		return hms;
	}
	
	/**
	 * 将yyyyMMddHHmmss转换成
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String parseTime(String time){
	    String dateStr = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dateStr = target.format(format.parse(time));
		} catch (ParseException e) {
			return time;
		}
		
		return dateStr;
	}
	
	/**
	 * 获取系统时间 yyyy年mm月 hh:MM:ss
	 * @return
	 */
	public static String getTimeP(){
		String time = nowTime();
		String tmpTime = time.substring(0, 4)+"年"+time.substring(4, 6)+"月"+time.substring(6, 8)+"日 "+time.substring(8, 10)+":"+time.substring(10,12)+":"+time.substring(12,14);
		
		return tmpTime;
	}
	
   /**
     * 将DATE类型转换成字符串（yyyy-MM-dd）
     *
     * @param date
     * @return
     */
    public static String getStringDate(Date date) {
        if (date==null){
        	return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);

        return str;
    }
    
    /**
     * 将Timestamp类型转换成字符串（yyyy-MM-dd）
     *
     * @param date
     * @return
     */
    public static String getStringTimestamp(Timestamp date) {
        if(date == null){
        	return " ";
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        DateFormat form = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        form.setTimeZone(TimeZone.getDefault());
        String str = form.format(date);

        return str;
    }
}
