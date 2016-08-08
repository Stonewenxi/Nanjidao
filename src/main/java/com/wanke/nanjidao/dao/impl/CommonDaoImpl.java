package com.wanke.nanjidao.dao.impl;

import com.wanke.nanjidao.dao.CommonDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * *******************************************
 * Author 56
 * Data   3/9/16 11:58 AM
 * E-mail mysherrymyqueen@outlook.com
 * *******************************************
 * Function 项目表数据库接口实例
 */
@Repository
public class CommonDaoImpl implements CommonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> int insert(T t) {
        Session session = null;
        int ans = -1;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ans = (int) session.save(t);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ans;
    }

    @Override
    public <T> Object selectById(Class<T> cls, int id) {
        Session session = null;
        Object obj = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(cls);
            criteria.add(Restrictions.eq("id", id));
            obj = criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public <T> List selectAll(Class<T> cls) {
        Session session = null;
        List list = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(cls);
            list = criteria.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

//    @Override
//    public <T> void remove(T t) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(t);
//        transaction.commit();
//        session.close();
//    }


}
