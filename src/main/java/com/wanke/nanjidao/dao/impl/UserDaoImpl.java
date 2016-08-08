package com.wanke.nanjidao.dao.impl;

import com.wanke.nanjidao.dao.UserDao;
import com.wanke.nanjidao.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:02 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:用户相关数据操作
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name, String pwd) {
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("admin", name));
            criteria.add(Restrictions.eq("password", pwd));
            user = (User) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }
}
