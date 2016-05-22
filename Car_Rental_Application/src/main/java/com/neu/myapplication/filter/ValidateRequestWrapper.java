package com.neu.myapplication.filter;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ValidateRequestWrapper extends HttpServletRequestWrapper {
	public ValidateRequestWrapper(HttpServletRequest servletRequest) {
	        super(servletRequest);
	    }
	    
	        @Override
	    public String getHeader(String name) {
	        String value = super.getHeader(name);
	        return sanitize(value);
	    }
	
	    
	    @Override
	    public String[] getParameterValues(String parameter) {
	        String[] values = super.getParameterValues(parameter);
	        if (values == null) {
	            return null;
	        }
	        int count = values.length;
	        String[] encodedValues = new String[count];
	        for (int i = 0; i < count; i++) {
	            encodedValues[i] = sanitize(values[i]);
	        }
	        return encodedValues;
	    }
	
	    
	    @Override
	    public String getParameter(String parameter) {
	        String value = super.getParameter(parameter);
	        return sanitize(value);
	    }
	    private String sanitize(String value) {
	        if (value != null) {
	            value = value.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();
	            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
	            value = scriptPattern.matcher(value).replaceAll("");
	            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
	            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	            value = scriptPattern.matcher(value).replaceAll("");
	            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
	            value = scriptPattern.matcher(value).replaceAll("");
	            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
	            value = scriptPattern.matcher(value).replaceAll("");
	           
	        }
	        return value;
	    }
	    }

