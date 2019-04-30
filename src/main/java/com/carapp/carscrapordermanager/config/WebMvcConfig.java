package com.carapp.carscrapordermanager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    private static final List<String> formarts = new ArrayList<String>(4);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }



    @Override
    public void addFormatters(FormatterRegistry registry) {


        registry.addConverter(new Converter<String,Date>(){
            @Override
            public Date convert(String source) {
                String value = source.trim();
                if ("".equals(value)) {
                    return null;
                }
                if(source.matches("^\\d{4}-\\d{1,2}$")){
                    return parseDate(source, formarts.get(0));
                }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                    return parseDate(source, formarts.get(1));
                }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                    return parseDate(source, formarts.get(2));
                }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                    return parseDate(source, formarts.get(3));
                }else {
                    try{
                        //其他按时间戳处理
                        Long timeStamp = Long.parseLong(source);
                        return new Date(timeStamp);
                    }catch (Exception e) {
                        throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
                    }

                }
            }
        });
    }

    public  Date parseDate(String source, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(source);
        } catch (Exception e) {
            logger.error("时间转换错误：{},错误原因：{}",source,e.toString());
        }
        return date;
    }
}
