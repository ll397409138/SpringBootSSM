package com.carapp.carscrapordermanager.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Autowired
    private MyDateFormat  myDateFormat;


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
                return myDateFormat.parse(source,null);
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


    @Bean
    public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {
        ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
        // ObjectMapper为了保障线程安全性，里面的配置类都是一个不可变的对象
        // 所以这里的setDateFormat的内部原理其实是创建了一个新的配置类
        mapper.setDateFormat(myDateFormat);
        MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
                mapper);
        return mappingJsonpHttpMessageConverter;
    }



    @Bean
    public MyDateFormat getMyDateFormat(){
        ObjectMapper mapper = jackson2ObjectMapperBuilder.build();

        DateFormat dateFormat = mapper.getDateFormat();
        return new MyDateFormat(dateFormat);

    }


}
