package com.t1.project.core.aspect;

import com.t1.project.core.model.DataSourceErrorLog;
import com.t1.project.core.repository.DSErrorLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    final DSErrorLogRepository dsErrorLogRepository;

    @AfterThrowing(value = "@annotation(com.t1.project.core.aspect.annotation.LogDataSourceError)", throwing = "ex")
    public void LogDataSourceError(JoinPoint joinPoint, DataAccessException ex) {
        try {
            dsErrorLogRepository.save(DataSourceErrorLog.builder()
                    .errorMessage(ex.getMessage())
                    .stackTrace(Arrays.toString(ex.getStackTrace()))
                    .methodSignature(joinPoint.getSignature().toString())
                    .build()
            );
        } catch (Exception e) {
            log.error("LogDataSourceError ERROR: {}", e.getMessage());
        }
    }
}
