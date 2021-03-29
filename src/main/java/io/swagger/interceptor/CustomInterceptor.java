package io.swagger.interceptor;

import io.swagger.model.*;
import io.swagger.service.VerifyAccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CustomInterceptor.class);

    @Autowired
    HeaderBean headerBean;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle called");

        String xbic =request.getHeader("x-bic");
        String subjectDN =request.getHeader("SubjectDN");
        String institution =request.getHeader("Institution");

        // setting the headers in request scope bean HeaderBean.class
//        CustomSpringBean.getHeaderBean().setXbic(xbic);
//        CustomSpringBean.getHeaderBean().setSubjectDN(subjectDN);
//        CustomSpringBean.getHeaderBean().setInstitution(institution);
          headerBean.setXbic(xbic);
          headerBean.setSubjectDN(subjectDN);
          headerBean.setInstitution(institution);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("postHandle called");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion called");

    }
}
