import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

@Aspect
public class Logging {
    Date date=new Date();
    long startTime = 0;
    @Pointcut("@annotation(Loggable)")
    private void selectLoggable() {}

    @Before("selectLoggable()")
    public void beforeLoggable(JoinPoint jp) throws Throwable {
        startTime=System.currentTimeMillis();
        Integer[] size= (Integer[]) jp.getArgs()[0];
        int sizeTemp=size.length;
        System.out.println("Running sort in "+jp.getThis().getClass().getName()+" with array size "+sizeTemp);
    }


    @After("selectLoggable()")
    public void afterLoggable(JoinPoint jp) throws Throwable {
        jp.getThis();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Function sort in " + jp.getThis().getClass().getName() + " took "+duration+" ms");
    }
}
