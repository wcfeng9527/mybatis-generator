package com.mybatis.generator.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_YMD = "yyyy-MM-dd";
	public static final int monitorMinutes = -20;
	

	/**
	 * 将时间Date类型转换成yyyy-MM-dd HH:mm:ss格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String toFullString(Date date) {
		if(date == null){
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS);
		return sdf.format(date);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的字符串型转换成时间Date类
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date toFullDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMDHMS);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将时间Date类型转换成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String toYMDString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMD);
		return sdf.format(date);
	}

	/**
	 * 将yyyy-MM-dd格式的字符串型转换成时间Date类
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date toYMDDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YMD);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期时间加上天数
	 */
	public static Date calculateDate(String dateString, Integer days) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(PATTERN_YMD);

		try {
			c.setTime(format.parse(dateString));
			c.add(Calendar.DATE, days);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 日期时间加上天数(参数了类型 为date)
	 */
	public static Date calculateDate(Date date, Integer days) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(date);
			c.add(Calendar.DATE, days);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * <p>方法描述:日期加月数 </p>
	
	 * <p>方法备注: </p>
	 *
	 * @param date
	 * @param num
	 * @return
	 *
	 * <p>创建人：cp</p>
	 *
	 * <p>创建时间：2015年8月18日 下午5:42:47</p>
	 *
	 */
	public static Date calculateMonth(Date date, Integer month) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(date);
			c.add(Calendar.MONTH, month);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	public static Date calculateYear(Date date, Integer year) {
		Calendar c = Calendar.getInstance();
		
		try {
			c.setTime(date);
			c.add(Calendar.YEAR, year);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	

	/**
	 * 将Map中的日期参数转换为日期类型.
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate(Object date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(PATTERN_YMD);
		if (date.getClass().getName().equals("java.util.Date")) {
			return (Date) date;
		} else if (date.getClass().getName().equals("java.lang.String")) {
			try {
				return format.parse(date.toString());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 获得当前应用服务器所在时区日期
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	public static Date getNotNull(Date d) {
		return d != null ? d : null;
	}

	//
	// public static void main(String[] args) {
	// System.out.println(toFullString(new Date()));
	// System.out.println(toFullDate("2013-11-23 09:42:38"));
	// System.out.println(toYMDString(new Date()));
	// System.out.println(toYMDDate("2013-11-23"));
	// System.out.println(toFullString(calculateDate("2013-11-23",10)));
	// }

	/**
	 * 
	 * <p>
	 * 方法描述: 获取指定日期的后一天
	 * </p>
	 * 
	 * @param date
	 *            日期
	 * @return 指定日期的后一天
	 */
	public static Date getSpecifiedDayEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return parseShort(dayBefore);
	}

	/**
	 * 
	 * <p>
	 * 方法描述: 将日期字符串转换为Date对象
	 * </p>
	 * <p>
	 * 方法备注: 格式yyyy-MM-dd
	 * </p>
	 * 
	 * @param param
	 *            日期字符串
	 * @return Date对象
	 */
	public static Date parseShort(String param) {
		return parse(param, "yyyy-MM-dd");
	}

	public static Date parse(String param, String format) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
		}
		return date;
	}

	/**
	 * d2 is bigger than d1.
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double getDateDiff(Date d1, Date d2){
		double diff = (d2.getTime() - d1.getTime());
		return diff/(1000*60*60*24);
	}
	
	public static Date getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String tmp = sdf.format(now);
		try {
			return sdf.parse(tmp);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 加一天，用于条件查询
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateAddOne(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(str));
		cal.add(Calendar.DATE, 1);

		return cal.getTime();
	}
	
	/**
     * 加几小时，用于条件查询
     * 
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date getDateAddHour(String str,int hour) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(str));
        cal.add(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }
    
    public static Date getDateAddHour(Date date, Integer hour) {
        Calendar c = Calendar.getInstance();
//      SimpleDateFormat format = new SimpleDateFormat(PATTERN_YMD);
        try {
            c.setTime(date);
            c.add(Calendar.HOUR_OF_DAY, hour);
            return c.getTime();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Date getDateAddMinute(Date date, Integer minute) {
        Calendar c = Calendar.getInstance();
//      SimpleDateFormat format = new SimpleDateFormat(PATTERN_YMD);
        try {
            c.setTime(date);
            c.add(Calendar.MINUTE, minute);
            return c.getTime();
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 计算两个日期相差的天数
     * @param smallDate  较小的日期
     * @param bigDate	较大的日期
     * @return
     * @throws ParseException 
     */
    public static int daysBetween(Date smallDate,Date bigDate) throws ParseException{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date smdate=sdf.parse(sdf.format(smallDate));  
		Date bdate=sdf.parse(sdf.format(bigDate));  
		Calendar cal = Calendar.getInstance();   
		cal.setTime(smdate);    
		long time1 = cal.getTimeInMillis();                 
		cal.setTime(bdate);    
		long time2 = cal.getTimeInMillis();         
		long between_days=(time2-time1)/(1000*3600*24);  
		return Integer.parseInt(String.valueOf(between_days));
	}
}
