package org.kepler.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.kepler.App;
import org.kepler.Book;
import org.springframework.core.annotation.Order;
import java.lang.reflect.Method;


@Aspect
@Order(20)
public class AspectOrderedSecond {

    @Before("execution(public void getBook())")
    // for all Libraries getBook methods!
    public void beforeGetBookAdvice() {
        App.logger.trace("Before all libraries GetBookAdvice. Getting book!");
    }

    @Before("execution(public void *Magazine())")
    // for all Libraries Magazine void methods!
    public void beforeMagazineAdvice() {
        App.logger.trace("Before all MagazineAdvice. Void methods!");
    }

    @Before("execution(public * return*())")
    // for all Libraries return methods!
    public void beforeReturnBookAdvice() {
        App.logger.trace("Before all libraries ReturnAllAdvice. Return methods!");
    }

    @Before("execution(void buy*(org.kepler.Book, int))")
    // for all Libraries Buy methods! With two parameters
    // Book <- is a bean!
    public void beforeBuyAdviceTwoParameters(JoinPoint joinPoint) {
        App.logger.trace("Before all BuyAdvice. Two parameters.");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class<?> returnValue = methodSignature.getReturnType();
        String nameMethod = methodSignature.getName();
        App.logger.trace("Method signature: " + method.toString());
        App.logger.trace("Returning type: " + returnValue.toString());
        App.logger.trace("Method name: " + nameMethod);

        Object[] args = joinPoint.getArgs();
        for (Object obj: args) {
            if (obj instanceof Book) {
                App.logger.trace("Field name: " + obj);
                App.logger.trace("Book name: " + ((Book) obj).getName());
                App.logger.trace("Create year: " + ((Book)obj).getYear());
            }
            if (obj instanceof Integer) {
                App.logger.trace("Cost: " + obj);
            }
        }

    }

    @Before("execution(void buy*(*))")
    // for all Libraries Buy methods! With one any parameter
    public void beforeBuyAdviceOneAnyParameter() {
        App.logger.trace("Before all BuyAdvice. One any parameter.");
    }

}