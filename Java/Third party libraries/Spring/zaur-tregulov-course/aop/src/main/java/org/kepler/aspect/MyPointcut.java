package org.kepler.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.kepler.*;


@Aspect
public class MyPointcut {
    @Pointcut("execution(* *(..))")
    // reference pointcut
    public void afterAllMethods() {}

    @Pointcut("execution(* buy*(..))")
    public void afterBuyMethods() {}

    @Pointcut("execution(* return*(..))")
    public void afterReturnMethods() {}

    @Pointcut("execution(* get*(..))")
    public void afterGetMethods() {}

    @Pointcut("execution(* getName(..))")
    // getName book in bean! filter!
    public void afterGetBookNameMethods() {}

    @Pointcut("execution(* getYear(..))")
    // getName book in bean! filter!
    public void afterGetBookYearMethods() {}

    @Pointcut("(afterBuyMethods() || afterReturnMethods() || afterGetMethods()) " +
            " && !afterGetBookNameMethods() && !afterGetBookYearMethods()")
    public void afterAllMethodsByNotGetNameInBean() {}
}
