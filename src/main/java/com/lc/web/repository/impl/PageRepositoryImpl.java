package com.lc.web.repository.impl;

import com.lc.web.utils.MessageUtils;
import com.lc.web.utils.PageUtil;
import com.lc.web.MessageKey;
import com.lc.web.ResultCode;
import com.lc.web.exception.CustomRunTimeException;
import com.lc.web.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by Liang on 2016/12/29.
 */
@Repository("pageRepositoryImpl")
public class PageRepositoryImpl <T> implements PageRepository {
    @Autowired
    private MessageUtils messageUtils;


    @Autowired(required = true)
    @PersistenceContext(unitName = "entityManagerFactoryPrimary")
    private EntityManager em1;


    @Override
    public Long findHqlCount(String hql) {

        Long count = null;
        try{
            Query query = em1.createQuery(hql);
            count = (Long) query.getSingleResult();
        }catch (Exception e){
            throw new CustomRunTimeException(ResultCode.SYSTEM_ERROR, MessageKey.SYSTEM_ERROR, new Object[]{" findWrokOrderHqlCount "});
        }
        return count;
    }


    @Override
    public List<T> findHqlPageQuery(String hql, PageUtil pageUtil){
        List<T> result = null;
        try{
            Query query = em1.createQuery(hql);
            query.setFirstResult((int) ((pageUtil.getPageNumber() - 1) * pageUtil.getLimit()));
            query.setMaxResults(pageUtil.getLimit());
            result = (List<T>) query.getResultList();
        }catch (Exception e){
            throw new CustomRunTimeException(ResultCode.SYSTEM_ERROR, MessageKey.SYSTEM_ERROR, new Object[]{" findWorkOrderHqlPageQuery "});
        }
        return result;
    }


}
