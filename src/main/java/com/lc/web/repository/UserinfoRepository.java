package com.lc.web.repository;

import com.lc.web.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_user_info")
@Qualifier("userinfoRepository")
public interface UserinfoRepository extends CrudRepository<UserInfo,Long> {
    @Query("FROM UserInfo WHERE user_qq = ? AND user_password = ?")
    UserInfo findUserByQQAndPad(String user_qq, String pswd);

    @Query("SELECT uid FROM UserInfo WHERE user_qq = ? ")
    Long findUidByQQ(String user_qq);
}
