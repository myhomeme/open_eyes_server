package com.sitech.paas.common.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 实现spring boot统一处理响应体接口，拦截Controller方法的返回值，统一处理返回值/响应体
 *
 * @author huangzb
 * @date 2022/4/22
 */
@RestControllerAdvice("com.sitech.paas")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @param returnType    返回类型
     * @param converterType 选定的转换器类型
     * @return 此处如果返回false , 则不执行当前Advice的业务
     */
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 统一处理响应体，SneakyThrows注解能够包含每一段代码形成runtime exception向上抛
     *
     * @param body                  要写入的正文
     * @param returnType            控制器方法的返回类型
     * @param selectedContentType   通过内容协商选择的内容类型
     * @param selectedConverterType 选择写入响应的转换器类型
     * @param request               当前请求
     * @param response              当前响应
     * @return 传入的主体或修改的（可能是新的）实例
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {
        if (body instanceof String) {
            // 使用Jackson的转json方法，将响应转换成json
            return objectMapper.writeValueAsString(ResponseResult.success(body));
        }
        if(body instanceof ResponseResult){
            return body;
        }
        return ResponseResult.success(body);
    }
}
