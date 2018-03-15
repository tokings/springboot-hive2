package com.embraces.hive.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.embraces.hive.mvc.ExtMessageSource;

public class ResponseJSON {

    public static final String CONTENT_TYPE_CONTENT = "application/json;charset=UTF-8";

    public static final String CONTENT_TYPE = "Content-Type";

    private String validateMessagesShowId = "_validatorMessage";

    private String repeatSubmitToken;

    private String url;

    private boolean status = true;// success or failure/excetpion

    private int httpstatus = 200;// http status

    private String redirectUrl;

    private Object data;

    private String[] filterNameForData = null;
    // private Map<String,List<String>> filterNameForData= null;

    private boolean isValidateMessage;

    private String exceptionMessage;

    private String exceptionStack;

    /**
     * 自定义的显示信息，这部分信息会在alert中显示出来
     */
    private List<String> messages = null;

    /**
     * 自定义的显示信息，这部分信息会在alert中显示出来
     */
    private String message = null;

    /**
     * 验证信息
     */
    private Map<String, String> validateMessages = new HashMap<String, String>();

    private ResponseJSON() {
    }

    public String getValidateMessagesShowId() {
        return validateMessagesShowId;
    }

    public String getMessage() {
        return message;
    }

    public ResponseJSON setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseJSON changeValidMessageShowId(String validateMessagesShowId) {
        this.validateMessagesShowId = validateMessagesShowId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ResponseJSON setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public ResponseJSON setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public ResponseJSON setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public int getHttpstatus() {
        return httpstatus;
    }

    public ResponseJSON setHttpstatus(int httpstatus) {
        this.httpstatus = httpstatus;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseJSON addDatePair(String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        } else if (!(data instanceof Map)) {
            throw new RuntimeException("addDatePair must be hashmap");
        }
        ((Map<String, Object>) data).put(key, value);
        return this;
    }

    public ResponseJSON setData(Object data) {
        this.data = data;
        return this;
    }

    public List<String> getMessages() {
        return messages;
    }

    public Map<String, String> getValidateMessages() {
        return validateMessages;
    }

    public ResponseJSON alertSuccess() {
        if (this.messages == null) {
            this.messages = new ArrayList<String>();
        }
        this.messages.add(ExtMessageSource.getMessage("common.message.operationSuccess", "操作成功"));
        return this;
    }

    public ResponseJSON addAlertMessage(String message) {
        if (this.messages == null) {
            this.messages = new ArrayList<String>();
        }
        this.messages.add(message);
        return this;
    }

    public ResponseJSON addMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseJSON addValidationMessages(String key, String message) {
        this.validateMessages.put(key, message);
        return this;
    }

    public static ResponseJSON instance() {
        return new ResponseJSON();
    }

    public ResponseJSON addAlertMessages(List<String> messages) {
        if (this.messages == null) {
            this.messages = new ArrayList<String>();
        }
        for (String msg : messages) {
            this.messages.add(msg);
        }
        return this;
    }

    public ResponseJSON addAlertMessageKey(String... keys) {
        if (this.messages == null) {
            this.messages = new ArrayList<String>();
        }
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                String message = ExtMessageSource.getMessage(key, key);
                this.messages.add(message);
            }
        }
        return this;
    }

    public boolean getIsValidateMessage() {
        return isValidateMessage;
    }

    public ResponseJSON setIsValidateMessage(boolean isValidateMessage) {
        this.isValidateMessage = isValidateMessage;
        return this;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public ResponseJSON setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }

    public String getExceptionStack() {
        return exceptionStack;
    }

    public ResponseJSON setExceptionStack(String exceptionStack) {
        this.exceptionStack = exceptionStack;
        return this;
    }

    public String toJSON() {
        return JsonUtils.toJson(this, this.filterNameForData);
        // return JSONArray.toJSONString(this.filterNameForData);
    }

    public ResponseEntity<String> responseEntity() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(CONTENT_TYPE, CONTENT_TYPE_CONTENT);
        return new ResponseEntity<String>(this.toJSON(), responseHeaders, HttpStatus.OK);
    }

    public String getRepeatSubmitToken() {
        return repeatSubmitToken;
    }

    public ResponseJSON setRepeatSubmitToken(String repeatSubmitToken) {
        this.repeatSubmitToken = repeatSubmitToken;
        return this;
    }

    public ResponseJSON addFilterName(String... names) {
        this.filterNameForData = names;
        return this;
    }
}
