package org.kepler.aop;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    
    @Around("execution(* *.publishComment(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        logger.log(Level.INFO, "Method name: {0}\nParameters: {1}\n", new Object[]{methodName, Arrays.asList(args)});
        
        logger.log(Level.INFO, "Method will be executed!");
        Object returnedByMethod = joinPoint.proceed(args);
        logger.log(Level.INFO, "Method executed!");
        
        return "FAIL!!! LOL"; // capture returning value and changing this!
    }
    
    @Before("@annotation(ToLog)")
    public void beforeDeleteLoggingAspect() {
        logger.log(Level.INFO, "Before deleting comment logging aspect!");
    }
    
}
