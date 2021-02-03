package io.swagger.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringBean {

    private static ApplicationContext applicationContext;

    CustomSpringBean(@Autowired ApplicationContext ctx){
        CustomSpringBean.applicationContext = ctx;
    }

    public static HeaderBean getHeaderBean(){
        HeaderBean hbean = applicationContext.getBean(HeaderBean.class);
        return hbean;
    }


}
