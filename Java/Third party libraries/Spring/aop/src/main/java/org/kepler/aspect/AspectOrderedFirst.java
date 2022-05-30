package org.kepler.aspect;

import org.kepler.App;
import org.springframework.core.annotation.Order;
import org.aspectj.lang.annotation.*;


@Aspect
@Order(10)
public class AspectOrderedFirst {

    @Before("execution(public void org.kepler.UniLibrary.getBook())")
    // for only UniLibrary getBook method!
    public void beforeUniLibraryGetBookAdvice() {
        App.logger.warn("Before only UniLibrary GetBookAdvice. Getting book!");
    }

}