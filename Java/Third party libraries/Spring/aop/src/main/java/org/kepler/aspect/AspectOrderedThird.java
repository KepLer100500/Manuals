package org.kepler.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.kepler.*;
import org.springframework.core.annotation.Order;
import java.util.*;


@Aspect
@Order(30)
public class AspectOrderedThird {

    @After("org.kepler.aspect.MyPointcut.afterAllMethodsByNotGetNameInBean()")
    // All Libraries all methods! Any number of parameters. Private and Public methods etc. 
    // After working anyway! Normal end method or get exception.
    // ~ After Finally
    public void afterAdvice() {
        App.logger.error("After all. Return and Get and Buy!");
    }
    
    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterGetStudentsAdvice(List<Student> students) {
        App.logger.warn("afterAddStudentAdvice!!!");
        Student student = students.get(0);
        student.setNameSurname("!!! KepLer !!!");
        student.setAvgRate(500.0);
    }

    @AfterThrowing(pointcut = "execution(* badListStudents())", throwing = "error")
    public void afterThrowingAdvice(Throwable error) {
        App.logger.error("Catching exception in Advice! " + error.toString());
    }

    @Around("execution(public String putBook())")
    public Object aroundPutBookAdvice(ProceedingJoinPoint proceedingJoinPoint) 
        throws Throwable {
        App.logger.warn("Start around advice!");
        Object result = proceedingJoinPoint.proceed();
        result = "I change this return!!!";
        App.logger.warn("End around advice!");
        return result;
    }
    
}