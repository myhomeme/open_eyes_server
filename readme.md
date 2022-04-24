# OE告警系统2.0

[TOC]

# 1.前言

open_eyes告警系统2.0为全新的框架，原系统基础的是[ruoyi](http://doc.ruoyi.vip/)系统3.0，现在ruoyi系统已经迭代到4.7，随着工具更多的重点落在告警方面，并且前后端分离的大趋势下，open_eyes2.0借鉴ruoyi4.7代码，完成告警2.0的新架构框架

**系统需求**

- JDK >= 1.8
- MySQL >= 5.7
- Maven >= 3.0



# 2.快速了解

本项目是一个 Java EE 企业级平台，提供基于日志的告警系统查询



# 3.后台手册

## 3.1 统一响应

使用RestControllerAdvice和ResponseBodyAdvice接口实现所有controller的统一响应格式设置

```java
{
    "code": 200,
    "msg": "操作成功",
    "data": "Hello World!",
    "timestamp": 1650770553710
}
```

使用注解SneakyThrows和注解ExceptionHandler处理全局的异常，指定返回的接口为响应头为500,将所有的catch部分的异常装成runtime exception抛出

```java
{
    "code": 500,
    "msg": "/ by zero",
    "data": "java.lang.ArithmeticException: / by zero\r\n\tat com.sitech.paas.admin.web.controller.MyTestController.getException(MyTestController.java:27)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat ...",
    "timestamp": 1650783981148
}
```











# 4.更新日志

##  v2.0.0

- v2.0.0 2022-04-22
  - 1.框架依赖完成spring boot+mybatis plus+swagger+druid
  - 2.增加mybatis plus的代码生成器



> 引用
>
> [SpringBoot 如何统一后端返回格式](https://juejin.cn/post/6986800656950493214)
>
> 
