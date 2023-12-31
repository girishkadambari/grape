package com.grape.annotations;

import com.grape.specificiations.BaseSpecificationsBuilder;
import com.grape.specificiations.SearchOperation;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecificationHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return BaseSpecificationsBuilder.class.equals(parameter.getParameterType().getSuperclass());
    }

    // ":", "!", ">", "<", "~", "@" % * wont work here
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String query = webRequest.getParameter("query");
        BaseSpecificationsBuilder builder = (BaseSpecificationsBuilder) parameter.getParameterType().newInstance();
        String operationSetExper = getOperationSetExper("|");
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)([a-zA-Z_0-9#\\.\\-\\&\\\\^\\(\\)\\%\\\\$\\s\\p{L}]+)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(query + ",");
        while (matcher.find()) {
            String prefix = matcher.group(3);
            String value = matcher.group(4);
            if (!prefix.contains("*")) {
                value = prefix + value;
                prefix = "";
            }
            builder.with(matcher.group(1), matcher.group(2), URLDecoder.decode(value), prefix, matcher.group(5));
        }

        return builder;
    }

    private String getOperationSetExper(String separator) {
        String[] simpleOperationSet = SearchOperation.SIMPLE_OPERATION_SET;
        String operantionSetExper = String.join(separator, simpleOperationSet);
        return operantionSetExper;
    }
}

