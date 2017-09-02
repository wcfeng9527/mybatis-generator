package com.mybatis.generator.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 项目名称：<br>
 * *********************************<br>
 * <P>类名称：StringUtils</P>
 * *********************************<br>
 * <P>类描述：</P>
 * 创建人：<br>
 * 创建时间：2014-9-28 下午5:23:17<br>
 * @version 1.0<br>
 */
public class CBStringUtils {

	
	/**
	 * 
	 * <p>方法描述: 根据指定长度自动左补零 </p>
	 *
	 * <p>方法备注: 根据指定长度自动左补零</p>
	 *
	 * @param sourceStr 源数字
	 * @param formatLength 指定长度
	 * @return 指定长度数字，不足补零
	 *
	 * <p>创建人：litf</p>
	 *
	 * <p>创建时间：2014-9-28 下午5:23:34</p>
	 *
	 */
	public static String frontZeroFill(Integer sourceStr,int formatLength){     
	      String newString = String.format("%0"+formatLength+"d", sourceStr);     
	      return  newString;     
	} 
	
	/**
	 * <p>方法描述: 根据流水号生成损益单编号</p>
	 *
	 * <p>方法备注: 根据流水号生成损益单编号</p>
	 *
	 * @param sourceStr
	 * @return
	 *
	 * <p>创建人：litf</p>
	 *
	 * <p>创建时间：2014-9-28 下午6:34:30</p>
	 *
	 */
	public static String getPLNO(Integer sourceStr){
		String no = frontZeroFill(sourceStr, 8);
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String now = format.format(new Date());
		return "SY"+ now + no;
	}
	
	/**
	 * <p>方法描述: 格式化流水号</p>
	 *
	 * <p>方法备注: </p>
	 *
	 * @param type
	 * @param serial
	 * @return
	 *
	 * <p>创建人：litf</p>
	 *
	 * <p>创建时间：2014-10-24 上午10:04:51</p>
	 *
	 */
	public static String formatSerialNumber(String type,Integer serial,int len){
		String no = frontZeroFill(serial, len);
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String now = format.format(new Date());
		return type + now + no;
	}
	
	
	public static String getResultStr(Object o) {
		return o !=null ? o.toString() :"";
	}
	
	public static boolean isEqualIgnoreCase(String a, String b) {
		if(a == null || b == null)
			return false;
		return a.trim().toUpperCase().equals(b.trim().toUpperCase());
	}
	/**
	 * <p>方法描述: 根据单据类型生成单据流水号</p>
	 *
	 * <p>方法备注: 根据单据类型生成单据流水号</p>
	 *
	 * @param sourceStr
	 * @return
	 *
	 * <p>创建人：litf</p>
	 *
	 * <p>创建时间：2014-9-28 下午6:34:30</p>
	 *
	 */
	public static String getPLNO(String billType,Integer sourceStr){
		String no = frontZeroFill(sourceStr, 8);
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String now = format.format(new Date());
		return billType + now + no;
	}

    /**
     * Escape SQL single-quotation.
     */
	public static StringBuffer escapeQuotation(String src) {
        StringTokenizer st = new StringTokenizer(src, "'", true);
        StringBuffer sb = new StringBuffer();
        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if(t.equals("'")) {
                sb.append("''");
            } else {
                sb.append(t);
            }
        }
        return sb;
    }
	
	public static String trimStr(String str){
		return str == null ? "" : str.trim();
	}
	
	public static String toUpperCase(Object str){
		return toString(str).toUpperCase();
	}
	
	/**
	 * remove subString from pareString
	 * @param pareString 
	 * @param subString ---should be removed.
	 * @return
	 */
	public static String removeSubString(String pareString, String subString){
		if(pareString.indexOf(subString) > -1){
			pareString = pareString.substring(0,pareString.indexOf(subString)) 
					+ pareString.substring(pareString.indexOf(subString)+subString.length(), pareString.length());
			
		}
		return pareString;
	}
	
	/**
	 * return String of the Object
	 */
	public static String toString(Object obj){
		return obj == null ? "" : obj.toString();
	}
	
	
	
	/**
	 * 
	 * <p>方法描述:转码 </p>
	 *
	 * <p>方法备注: </p>
	 *
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 * <p>创建人：陈鹏</p>
	 *
	 *
	 */
	
	public static String toTranscoding(String str) throws UnsupportedEncodingException{
		return str==null?"":new String(str.getBytes("ISO-8859-1"),"utf-8");	
	}

	
	public static String convertFirstCharToUpper(String param)
	{
		if(Character.isUpperCase(param.charAt(0)))
			return param;
		else {
			return (new StringBuilder()).append(Character.toUpperCase(param.charAt(0))).append(param.substring(1)).toString();
		}
	}
	
	
	public static String convertFirstCharToLower(String param)
	{
		if(Character.isLowerCase(param.charAt(0)))
			return param;
		else {
			return (new StringBuilder()).append(Character.toLowerCase(param.charAt(0))).append(param.substring(1)).toString();
		}
	}
	
	/**
	 * 数据转换成java格式
	 * @param dataType
	 * @return
	 */
	public static String convertDataTypeToJavaType(String dataType)
	{
		String javaType="String";
		switch (dataType.toLowerCase()) {
		case "date":
		case "datetime":
			javaType = "Date";
			break;
		case "timestamp":
			javaType = "Timestamp";
			break;
		case "tinyint":
		case "smallint":
		case "mediumint":
		case "int":
		case "integer":
			javaType = "Integer";
			break;
		case "bigint":
			javaType = "Long";
			break;
		case "float":
		case "double":
			javaType = "Double";
			break;
		case "decimal":
			javaType = "BigDecimal";
			break;
		case "char":
		case "varchar":
			javaType="String";
			break;
		case "bit":
			javaType="Boolean";
			break;
		default:
			break;
		}
		return javaType;
	}
	
	
	/**
	 * 数据转换成Mapper格式
	 * @param dataType
	 * @return
	 */
	public static String convertDataTypeToMapperType(String dataType)
	{
		String jdbcType="String";
		switch (dataType.toLowerCase()) {
		case "datetime":
		case "timestamp":
			jdbcType = "TIMESTAMP";
			break;
		case "date":
			jdbcType = "DATE";
			break;
		case "time":
			jdbcType = "TIME";
			break;
		
		case "mediumint":
		case "int":
		case "integer":
			jdbcType = "INTEGER";
			break;
		case "smallint":
			jdbcType = "SMALLINT";
			break;
		case "tinyint":
			jdbcType = "TINYINT";
			break;
			
		case "bigint":
			jdbcType = "BIGINT";
			break;
		case "float":
			jdbcType = "FLOAT";
			break;
		case "double":
			jdbcType = "DOUBLE";
			break;
		case "decimal":
			jdbcType = "DECIMAL";
			break;
		case "char":
			jdbcType="CHAR";
			break;
		case "varchar":
			jdbcType="VARCHAR";
			break;
		case "bit":
			jdbcType="BIT";
			break;
		default:
			break;
		}
		return jdbcType;
	}
	
	
	/**
	 * chenpeng
	 * JAVA找到下划线并且把下划线后面的字母改成大写
	 * @param str
	 * @param anotherStr
	 * @return
	 */
	public static String getStrUnderlineUpper(String str,String  anotherStr) {
		anotherStr = handlerNumbersInStr(anotherStr);
		return handlerStrUnderLineUpper(str,anotherStr);
	}
	
	
	
	public static String handlerStrUnderLineUpper(String str,String  anotherStr){
		str=anotherStr;
		//如果最后一个是_ 不做转换
		if(str.indexOf("_")>0&&str.length()!=str.indexOf("_")+1){
			int lengthPlace=str.indexOf("_");
			str=str.replaceFirst("_", "");
			String s=str.substring(lengthPlace, lengthPlace+1);
			s=s.toUpperCase();
			anotherStr=str.substring(0,lengthPlace)+s+str.substring(lengthPlace+1);
		}else{
			return  anotherStr;
		}
		return handlerStrUnderLineUpper(str,anotherStr);
	}
	
	
	/**
	 * chenpeng
	 * 首字母大写   & 找到下划线并且把下划线后面的字母改成大写
	 * @param str
	 * @param anotherStr
	 * @return
	 */
	public static String getStrFirstCharAndUnderLineUpper(String str,String  anotherStr) {
		anotherStr = handlerNumbersInStr(anotherStr);
		
		return handlerStrFirstCharAndUnderLine(str,anotherStr);
	}
	
	public static String handlerStrFirstCharAndUnderLine(String str,String  anotherStr){
		str=anotherStr;
		//如果最后一个是_ 不做转换
		if(str.indexOf("_")>0&&str.length()!=str.indexOf("_")+1){
			int lengthPlace=str.indexOf("_");
			str=str.replaceFirst("_", "");
			String s=str.substring(lengthPlace, lengthPlace+1);
			s=s.toUpperCase();
			anotherStr=str.substring(0,lengthPlace)+s+str.substring(lengthPlace+1);
		}else{
			return  convertFirstCharToUpper(anotherStr);
		}
		return handlerStrFirstCharAndUnderLine(str,anotherStr);
	}
	
	
	
	
	public static String handlerNumbersInStr(String str){
		String string =	getNumbers(str);
		int index = str.indexOf(string);//数字的下标
		if(index == 0){//不包含数字时
			return str;
		}
		String s=str.substring(index-1, index);//数字下标前一位
		if(s.endsWith("_")){
			return str;
		}else{
			return str.substring(0, index);
		}
	}
	
	
	//截取数字    
	public static String getNumbers(String content) {    
	    Pattern pattern = Pattern.compile("\\d+");    
	    Matcher matcher = pattern.matcher(content);    
	    while (matcher.find()) {  
	       return matcher.group(0);    
	    }    
	    return "";    
	}  
	
	public static void main(String[] args) {
		String str = "j_position_county";
		String string = handlerNumbersInStr(str);

		System.out.println(string);
	}
}
