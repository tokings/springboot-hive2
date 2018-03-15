package com.embraces.hive.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.embraces.hive.util.ResponseJSON;
import com.google.common.base.Throwables;

public class AjaxRequestExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(AjaxRequestExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handler != null && handlerMethod.getMethodAnnotation(ResponseBody.class) != null) {
                ResponseJSON responseJSON = ResponseJSON.instance();
                ModelAndView modelAndView = new ModelAndView();
                if (ex instanceof EsRuntimeException) {
                    responseJSON.addMessage(ex.getMessage());
                    responseJSON.setStatus(false);
                } else {
                    Throwable rootCause = Throwables.getRootCause(ex);
                    logger.error(rootCause.toString(), ex);
                    responseJSON.addMessage(ex.getMessage() == null ? "系统异常" : ex.getMessage());
                    responseJSON.setStatus(false);
                }
                modelAndView.addObject("errorMessage", responseJSON.toJSON());
                modelAndView.setView(new StringView("errorMessage"));
                return modelAndView;
            }
        }
        ResponseJSON responseJSON = ResponseJSON.instance();
        ModelAndView modelAndView = new ModelAndView();
        Throwable rootCause = Throwables.getRootCause(ex);
        responseJSON.setStatus(false);
        responseJSON.addMessage(ex.getMessage() == null ? "系统异常" : ex.getMessage());
        modelAndView.addObject("errorMessage", responseJSON.toJSON());
        modelAndView.setView(new StringView("errorMessage"));
        logger.error(rootCause.toString(), ex);
        return modelAndView;
    }

    public String getStackTraceInfo(Throwable ex) {
        if (ex == null) {
            return "";
        }

        StringBuffer stackTraceInfo = new StringBuffer(ex.toString());
        StackTraceElement[] astacktraceelement = ex.getStackTrace();

        for (int i = 0; i < astacktraceelement.length; i++) {
            stackTraceInfo.append("\r\n\tat ").append(astacktraceelement[i]);
        }
        return stackTraceInfo.toString();
    }

    private void hander(ResponseJSON responseJSON, Map<String, String> validateMap) {
        // for (Map.Entry<String, String> validMessage : validateMap.entrySet())
        // {
        // responseJSON.addValidationMessages(validMessage.getKey(),
        // validMessage.getValue());
        // }
        String message = "";
        for (Map.Entry<String, String> validMessage : validateMap.entrySet()) {
            message += validMessage.getKey() + "=" + validMessage.getValue() + "\n";
        }
        responseJSON.addMessage(message);
        responseJSON.setStatus(false);
    }
}
