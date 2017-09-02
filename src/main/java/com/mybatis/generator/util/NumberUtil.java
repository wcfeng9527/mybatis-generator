package com.mybatis.generator.util;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberUtil {

    /**
     * convert a Integer to int. if null, return intForNull which set by caller.
     * @author jy 
     * @datetime 03/29/2010
     * @param Integer, int
     * @return int
     **/
    public static int getInt(Integer in, int intForNull) {
	if ( in ==null )
	    return intForNull;
	else
	    return in.intValue();
    }

    /**
     * convert a Integer to int. if null, return 0.
     * @author jy 
     * @datetime 03/29/2010
     * @param Integer
     * @return int
     **/
    public static int getInt(Integer in) {
	return getInt( in, 0);
    }
    
    /**
     * convert a Integer to int. if null, return 0.
     * @author jy 
     * @datetime 03/29/2010
     * @param Integer
     * @return int
     **/
    public static int getPositiveInt(Integer in) {
    	int value = getInt( in, 0);
    	if(value < 0){
    		return 0;
    	}
    	return value;
    }
 
    /**
     * convert a String to int. if null, return intForNull which set by caller.
     * @author jy 
     * @datetime 03/29/2010
     * @param String, int
     * @return int
     **/
    public static int getInt(String in, int intForNull) {
	int iRet = intForNull;
	try {
	    if ((in == null) || (in.trim().length() <= 0))
		iRet = intForNull;
	    else
		iRet = Integer.parseInt(in);
	} catch (NumberFormatException e) {
	    return iRet = intForNull;
	}
	
	return iRet;
    }

    /**
     * convert a String to int. if null, return 0.
     * @author jy 
     * @datetime 03/29/2010
     * @param String
     * @return int
     **/
    public static int getInt(String in) {
	return getInt( in, 0);
    }
    /**
     * convert a Object to int. if null, return 0.
     * @author Leoz 
     * @datetime 10/26/2012
     * @param Ojbect
     * @return int
     **/
    public static int getInt(Object in) {
    	if(in==null){
    		return getInt( "", 0);
    	}else{
    		return getInt( in.toString(), 0);
    	}
    }
    /**
     * 02/07/2012 convert Object to double 
     */
    public static double getDouble(Object in){
    	if(in == null){
    		return 0;
    	} else if(in instanceof BigDecimal){
    		return ((BigDecimal)in).doubleValue();
    	} else if(in instanceof Double){
    		return ((Double)in).doubleValue();
    	} else {
    		double rst = 0;
    		
    		try {
    			rst = Double.parseDouble(("" + in).trim());
			} catch (Exception e) {
				rst = 0;
			}
			
			return rst;
    	}
    }
    
    /**
     * 02/07/2012 convert Object to double 
     */
    public static long getLong(Object in){
    	if(in == null){
    		return 0;
    	} else if(in instanceof BigDecimal){
    		return ((BigDecimal)in).longValue();
    	} else if(in instanceof Double){
    		return ((Double)in).longValue();
    	} else {
    		long rst = 0;
    		
    		try {
    			rst = Long.parseLong(("" + in).trim());
			} catch (Exception e) {
				rst = 0;
			}
			
			return rst;
    	}
    }
    //short类型  判断是否为空
    public static Short getShort(Short in) {
    	if(in == null){
    		return 0;
    	}
    	return in;
    }
    
    
    public static <T> List<T> toNumberList(String strNumber, String regex) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	if(strNumber == null || strNumber.equals("")){
    		return null;
    	}
    	List<T> t = new ArrayList<T>();
    	String[] numberArray = strNumber.split(regex);
    	
    	for(String s: numberArray){
    		String methodName = "parse"+((T)s).getClass().getName();
    		Method m1 = ((T)s).getClass().getMethod(methodName, null);
    		
    		t.add((T)(m1.invoke(s, null)));
    	}
    	return t;
    }
    
    public static List<Long> toLongList(String strNumber, String regex){
    	List<Long> t = new ArrayList<Long>();
    	if(strNumber == null || strNumber.equals("")){
    		return t;
    	}
    	String[] numberArray = strNumber.split(regex);
    	for(String s: numberArray){
    		t.add(NumberUtil.getLong(s));
    	}
    	
    	return t;
    }
    
    public static Set<Long> toLongSet(String strNumber, String regex){
    	Set<Long> t = new HashSet<Long>();
    	if(strNumber == null || strNumber.equals("")){
    		return t;
    	}
    	String[] numberArray = strNumber.split(regex);
    	for(String s: numberArray){
    		t.add(NumberUtil.getLong(s));
    	}
    	
    	return t;
    }
    
    public static Set<String> toStringSet(String strNumber, String regex){
        Set<String> t = new HashSet<String>();
        if(strNumber == null || strNumber.equals("")){
            return t;
        }
        String[] numberArray = strNumber.split(regex);
        for(String s: numberArray){
            t.add(s);
        }
        
        return t;
    }
    
    public static short getShort(String shot,short shortForNull) {
		short resuFlag = shortForNull;
		try {
			 if ((shot == null) || (shot.trim().length() <= 0))
				 resuFlag = shortForNull;
			 else
			 resuFlag = Short.parseShort(shot);
		} catch (Exception e) {
			return  resuFlag = shortForNull;
		}
		return resuFlag;
	}
    
    public static short getShort(String shot) {
		return getShort(shot, (short)0);
	}
    
    public static short getShort(Object shot) {
		if(shot == null){
			return getShort("", (short)0);
		}else {
			return getShort(shot.toString(), (short)0);
		}
	}
    
    public static short getShort(Short shot,short shortForNull) {
		if(shot == null)
			return shortForNull;
		else
			return shot.shortValue();
	}
    
    
    public static Float getFloat(String str) {
			 if ((str == null) || (str.trim().length() <= 0))
				return (float) 0;
			 else
			 return Float.parseFloat(str);
	}
    
    
    
//    public static void main(String[] args) {
//		String a = "1111";
//		int b = NumberUtil.getInt(a, -999999);
//		execSql(a, b);
//		
//	}
//    
//    public static void execSql(String a, int b){
//    	/*
//    	 * select *ｆｒｏｍ　ｓｋｕ_main where sku_name = %a, upc_no = %a, sku_id = %b 
//    	 *
//    	 */
//    	System.out.println(a+"%%%%"+b);
//    }
}
