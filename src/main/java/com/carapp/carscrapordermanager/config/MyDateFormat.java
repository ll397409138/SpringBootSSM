package com.carapp.carscrapordermanager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MyDateFormat extends DateFormat {

    private static final List<String> formarts = new ArrayList<String>(4);

    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }


    private DateFormat dateFormat;

   // private SimpleDateFormat format1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(MyDateFormat.class);

    public MyDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {

        Date date = null;

        try {


            if(source.matches("^\\d{4}-\\d{1,2}$")){
                return parseDate(source, formarts.get(0),pos);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return parseDate(source, formarts.get(1),pos);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(2),pos);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(3),pos);
            }else {
                try{
                    //其他按时间戳处理
                    Long timeStamp = Long.parseLong(source);
                    return new Date(timeStamp);
                }catch (Exception e) {
                    throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
                }

            }

        } catch (Exception e) {

            date = dateFormat.parse(source, pos);
        }

        return date;
    }

    // 主要还是装饰这个方法
    @Override
    public Date parse(String source) throws ParseException {

        String value = source.trim();

        Date date = null;
        try {

            if(source.matches("^\\d{4}-\\d{1,2}$")){
                return parseDate(source, formarts.get(0),null);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return parseDate(source, formarts.get(1),null);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(2),null);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(3),null);
            }else {
                try{
                    //其他按时间戳处理
                    Long timeStamp = Long.parseLong(source);
                    return new Date(timeStamp);
                }catch (Exception e) {
                    throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
                }

            }

        } catch (Exception e) {

            // 不行，那就按原先的规则吧
            date = dateFormat.parse(source);
        }

        return date;
    }

    public  Date parseDate(String source, String format, ParsePosition pos) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            if(pos==null)
              date = (Date) dateFormat.parse(source);
            else
                date = (Date) dateFormat.parse(source,pos);
        } catch (Exception e) {
            logger.error("时间转换错误：{},错误原因：{}",source,e.toString());
        }
        return date;
    }

    // 这里装饰clone方法的原因是因为clone方法在jackson中也有用到
    @Override
    public Object clone() {
        Object format = dateFormat.clone();
        return new MyDateFormat((DateFormat) format);
    }

}
