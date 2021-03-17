package com.kangqing.mallcommon.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目前使用Swagger注解进行记录，此注解用于不使用swagger的项目中
 * 自定义注解，
 * 记录操作日志的模块、类型、描述
 * @author kangqing
 * @since 2021/1/7 10:35
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
public @interface OperLog {

    String operModule() default ""; // 操作模块

    OperTypeEnum operType() default OperTypeEnum.DEFAULT;  // 操作类型

    String operDesc() default "";  // 操作说明
}
