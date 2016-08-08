package com.wanke.nanjidao.dao.impl;

import com.wanke.nanjidao.dao.ProjectDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * *******************************************
 * Author: 56
 * Data:   3/17/16 4:13 PM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:项目专有操作实例类
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(HashMap<String, String> map, int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            StringBuilder builder = new StringBuilder("update Project p set");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.append(" p.").append(entry.getKey());
                builder.append("=").append("'").append(entry.getValue()).append("',");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(" where p.id=").append(id);
            Query query = session.createQuery(builder.toString());
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addOne(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //noinspection JpaQlInspection
            String hql = "update Project set interest=interest+1 where id=" + id;
            Query query = session.createQuery(hql);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //noinspection JpaQlInspection
            String hql = "update Project set state=1 where id=" + id;
            Query query = session.createQuery(hql);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
