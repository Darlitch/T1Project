package com.t1.project.core.aspect;

import com.t1.project.core.model.TimeLimitExceedLog;
import com.t1.project.core.repository.TLExceedLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class MetricAspect {

    @Value("${metric.timelimt-ms}")
    private long timeLimit;
    private final TLExceedLogRepository tlExceedLogRepository;

    @Around(value = "@annotation(com.t1.project.core.aspect.annotation.Metric)")
    public Object TLExceedRepository(ProceedingJoinPoint pJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = pJoinPoint.proceed();
        } finally {
            long timeExecute = System.currentTimeMillis() - startTime;
            if (timeExecute > timeLimit) {
                tlExceedLogRepository.save(TimeLimitExceedLog.builder()
                        .methodName(pJoinPoint.getSignature().toShortString())
                        .timeLimit(timeLimit)
                        .timeExecute(timeExecute)
                        .build()
                );
                log.info("Metric add new data for {}", pJoinPoint.getSignature().getName());
            }

        }
        return result;
    }
}
