package com.lc.web.repository;

import com.lc.web.pojo.TPeriodOdds;
import com.lc.web.pojo.TUserHistoryStatistics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_period_odds")
@Qualifier("tPeriodOddsRepository")
public interface TPeriodOddsRepository extends CrudRepository<TPeriodOdds,Long> {
    @Query(value = "FROM DeviceVersionInfo WHERE pid = :pid ",
            countQuery = "SELECT COUNT(1) FROM TPeriodOdds WHERE pid = :pid"
    )
    Page<TPeriodOdds> findPidNewVersion(@Param(value = "pid") Long pid, Pageable pageable);
}
