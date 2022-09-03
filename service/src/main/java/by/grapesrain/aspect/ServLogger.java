package by.grapesrain.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Aspect
public class ServLogger {
    private static final Logger log = LogManager.getLogger();

    @Pointcut("execution(public * by.grapesrain.services.*.* (..))")
    public void allServices() {
    }

    ;


    @Before("allServices()")
    public void printParametrs(JoinPoint joinPoint) {
        log.info("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        log.info(joinPoint.getTarget().getClass().getSimpleName());
        log.info(joinPoint.getSignature().getName());
        if (joinPoint.getArgs().length > 0) {
            for (Object argument : joinPoint.getArgs()) {
                log.info("---> " + argument.toString());
            }
        } else {
            log.info("---> void");
        }
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
