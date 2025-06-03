package com.t1.project.core.repository;

import com.t1.project.core.model.TimeLimitExceedLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TLExceedLogRepository extends JpaRepository<TimeLimitExceedLog, Long> {
}
