package com.embraces.hive.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class StringView extends AbstractView {
    public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";

    private String modelKey;

    public StringView(String modelKey) {
        setContentType(DEFAULT_CONTENT_TYPE);
        setExposePathVariables(false);
        this.modelKey = modelKey;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String content = (String) model.get(modelKey);
        if (content == null) {
            content = "";
        }
        response.setContentType(getContentType());
        response.setContentLength(content.getBytes("UTF-8").length);
        FileCopyUtils.copy(content.getBytes("UTF-8"), response.getOutputStream());
    }

}
