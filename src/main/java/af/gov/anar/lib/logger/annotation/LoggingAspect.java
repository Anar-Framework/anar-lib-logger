package af.gov.anar.lib.logger.annotation;

import af.gov.anar.lib.json.JsonUtility;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
// @Slf4j
// @Slf4j
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Before("@annotation(af.gov.anar.lib.logger.annotation.Loggable)")
    public void annotatedBeforeLoggingAdvice(JoinPoint joinPoint) throws Throwable{
        log.info("[" + joinPoint.getSignature().getDeclaringTypeName() + "]" +
                "[" + ((MethodSignature) joinPoint.getSignature()).getMethod().getName() + "] " +
                "Input Params : " + JsonUtility.javaObjectToJsonString(joinPoint.getArgs()));
    }

}
