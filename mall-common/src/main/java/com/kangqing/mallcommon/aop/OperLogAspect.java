package com.kangqing.mallcommon.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.kangqing.mallcommon.handler.LoginUserHandler;
import com.kangqing.mallcommon.log.SysOperLogService;
import com.kangqing.mallmbpg.pojo.SysOperLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * 操作日志处理器
 * @author kangqing
 * @since 2020/12/30 13:50
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class OperLogAspect implements Serializable {

    private final SysOperLogService sysOperLogService;

    private final LoginUserHandler loginUserHandler;

    public static final String LOGIN_SUCCESS = "{\"msg\":\"登录成功\",\"code\":\"200\",\"data\":null}";

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.kangqing.mallcommon.aop.OperLog)")
    public void operLogPointCut() {
    }

    /**
     * 指定了通知被应用的范围 包及其子包下所有类中的所有方法都应用切面里的通知
     */
    @Pointcut("execution(public * com.kangqing.mall.*.controller.*.*(..))")
    public void operExceptionLogPointCut() {
    }

    /**
     * 指定了通知被应用的范围 包中所有类的public方法都应用切面里的通知
     */
    @Pointcut("execution(public * com.kangqing.mall.*.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 通知方法会在目标方法调用之前执行
     * @param joinPoint 切入点
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
    }

    /**
     * 通知方法会在目标方法返回后执行
     * @param ret 返回结果
     */
    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
    }

    /**
     * 通知方法会将目标方法封装起来
     * @param joinPoint 切入点
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        //记录请求信息
        SysOperLog webLog = new SysOperLog();
        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // 获取操作
        OperLog opLog = method.getAnnotation(OperLog.class);
        if (opLog != null) {
            String operModule = opLog.operModule();
            OperTypeEnum operType = opLog.operType();
            String operDesc = opLog.operDesc();
            webLog.setOperModule(operModule); // 操作模块
            webLog.setOperType(operType.getType()); // 操作类型
            webLog.setOperDesc(operDesc); // 操作描述
        }
        long endTime = System.currentTimeMillis();
        webLog.setUserId(loginUserHandler.getCurrentUser().getId());//SecurityUtils.getLoginUserId());
        webLog.setStartTime(localDateTime);
        webLog.setSpendTime((int) (endTime - startTime));
        String urlStr = request.getRequestURL().toString();
        webLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        // 获取类名 + 方法名
        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;
        webLog.setMethodPath(methodName);
        webLog.setUri(request.getRequestURI());
        webLog.setUrl(request.getRequestURL().toString());
        webLog.setIp(IPUtils.getIpAddr(request));
        webLog.setMethod(request.getMethod());
        // 请求的参数
        Map<String, String> rtnMap = convertMap(Objects.requireNonNull(request).getParameterMap());
        // 将参数所在的数组转换成json
        String params = JSONUtil.toJsonStr(rtnMap);
        webLog.setParameter(params);
        webLog.setResult((String) result);

        log.info("[{}]", JSONUtil.formatJsonStr(JSONUtil.toJsonStr(webLog)));
        return result;
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPointCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        long startTime = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes)
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        SysOperLog operLog = new SysOperLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModule = opLog.operModule();
                OperTypeEnum operType = opLog.operType();
                String operDesc = opLog.operDesc();
                operLog.setOperModule(operModule); // 操作模块
                operLog.setOperType(operType.getType()); // 操作类型
                operLog.setOperDesc(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;

            // 请求的参数
            Map<String, String> rtnMap = convertMap(Objects.requireNonNull(request).getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSONUtil.toJsonStr(rtnMap);
            long endTime = System.currentTimeMillis();
            operLog.setUserId(loginUserHandler.getCurrentUser().getId());//SecurityUtils.getLoginUserId()); // 请求用户ID
            operLog.setStartTime(localDateTime);
            operLog.setSpendTime((int) (endTime - startTime));
            String urlStr = request.getRequestURL().toString();
            operLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
            operLog.setMethodPath(methodName);
            operLog.setIp(IPUtils.getIpAddr(request)); // 请求IP
            operLog.setUri(request.getRequestURI()); // 请求URI
            operLog.setUrl(request.getRequestURL().toString());
            operLog.setMethod(request.getMethod());
            operLog.setParameter(params); // 请求参数
            operLog.setResult(OperTypeEnum.LOGIN.getType().equals(operLog.getOperType()) ? LOGIN_SUCCESS :
                    JSONUtil.toJsonStr(keys)); // 返回结果
            sysOperLogService.save(operLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "operExceptionLogPointCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        long startTime = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes)
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        SysOperLog exLog = new SysOperLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModule = opLog.operModule();
                OperTypeEnum operType = opLog.operType();
                String operDesc = opLog.operDesc();
                exLog.setOperModule(operModule); // 操作模块
                exLog.setOperType(operType.getType()); // 操作类型
                exLog.setOperDesc(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;
            // 请求的参数
            Map<String, String> rtnMap = convertMap(Objects.requireNonNull(request).getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSONUtil.toJsonStr(rtnMap);
            long endTime = System.currentTimeMillis();
            exLog.setUserId(loginUserHandler.getCurrentUser().getId());//SecurityUtils.getLoginUserId()); // 请求用户ID
            exLog.setStartTime(localDateTime);
            exLog.setSpendTime((int) (endTime - startTime));
            String urlStr = request.getRequestURL().toString();
            exLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
            exLog.setMethodPath(methodName);
            exLog.setIp(IPUtils.getIpAddr(request)); // 请求IP
            exLog.setUri(request.getRequestURI()); // 请求URI
            exLog.setUrl(request.getRequestURL().toString());
            exLog.setMethod(request.getMethod());
            exLog.setParameter(params); // 请求参数
            //exLog.setResult(JSONUtil.toJsonStr(keys)); // 异常无返回结果
            exLog.setExceptionName(e.getClass().getName()); // 异常名称
            exLog.setExceptionMsg(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace())); // 异常信息

            sysOperLogService.save(exLog);

        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> convertMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<>();
        for (String key : paramMap.keySet()) {
            if ("password".equals(key)) {
                rtnMap.put(key, "******");
            } else {
                rtnMap.put(key, paramMap.get(key)[0]);
            }
        }
        return rtnMap;
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stet : elements) {
            sb.append(stet).append("\n");
        }
        return exceptionName + ":" + exceptionMessage + "\n\t" + sb.toString();
    }

}
