package com.lc.web.repository;

import com.lc.web.pojo.TUserHistoryStatistics;
import com.lc.web.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_user_history_statistics")
@Qualifier("tUserHistoryStatisticsRepository")
public interface TUserHistoryStatisticsRepository extends CrudRepository<TUserHistoryStatistics,Long> {

}
