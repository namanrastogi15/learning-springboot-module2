//package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.advices;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//@RestControllerAdvice
//public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
//
//    private final ObjectMapper objectMapper;
//
//    public GlobalResponseHandler(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public boolean supports(
//            MethodParameter returnType,
//            Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(
//            Object body,
//            MethodParameter returnType,
//            MediaType selectedContentType,
//            Class<? extends HttpMessageConverter<?>> selectedConverterType,
//            ServerHttpRequest request,
//            ServerHttpResponse response) {
//
//        if (body instanceof ApiResponse<?>) {
//            return body;
//        }
//
//        ApiResponse<Object> apiResponse = new ApiResponse<>(body);
//
//        if (body instanceof String) {
//            try {
//                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//                return objectMapper.writeValueAsString(apiResponse);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException("Could not convert response to JSON", e);
//            }
//        }
//
//        return apiResponse;
//    }
//}