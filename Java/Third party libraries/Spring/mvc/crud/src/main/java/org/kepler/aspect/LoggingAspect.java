package org.kepler.aspect;

import org.slf4j.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* org.kepler.dao.*.*Employee*(..))")
    public Object aroundLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.trace("Start method: " + methodName);
        Object result = proceedingJoinPoint.proceed();
        logger.trace("Finish method: " + methodName);
        return result;
    }

}