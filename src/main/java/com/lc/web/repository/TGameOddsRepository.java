package com.lc.web.repository;

import com.lc.web.pojo.TGameOdds;
import com.lc.web.pojo.TPeriodOdds;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_game_odds")
@Qualifier("tGameOddsRepository")
public interface TGameOddsRepository extends CrudRepository<TGameOdds,Long> {

}
