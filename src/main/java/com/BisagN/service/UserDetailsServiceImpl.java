package com.BisagN.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.BisagN.models.UserLogin;
import com.BisagN.repository.UserLoginRepository;
 
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	UserLogin appUser = userLoginRepository.findUser(userName);
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = userLoginRepository.getRoleByuserId(String.valueOf(appUser.getUserId()));
        System.out.println("cvdfgb"+roleNames);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames.size() > 0) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getPassword(), grantList);
        return userDetails;
    }
    
//    public UserLogin findByUsername(String uname) {
//		String hql = "FROM UserLogin U where U.userName=:uname ";
//		UserLogin users = null;
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		try {
//
//			Query query = session.createQuery(hql);
//			query.setParameter("uname", uname);
//			users = (UserLogin) query.uniqueResult();
//
//			tx.commit();
//			session.close();
//			return users;
//
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//			return users;
//		}
//
//	}
//    
    
//	@Transactional
//	public void lock(String username) {
//		UserLogin user = findByUsername(username);
//		if (user != null) {
//			UserLogin ua = (UserLogin) sessionFactory.getCurrentSession().load(UserLogin.class, user.getUserId());
//			ua.setAccountnonlocked(0);
//		}
//	}
	
//	@Transactional
//	public void lock(String username) {
//		UserLogin user = findByUsername(username);
//		if (user != null) {
//			Session s = sessionFactory.openSession();
//			Transaction t = s.beginTransaction();
//			Query query = s.createQuery(
//					"UPDATE UserLogin SET accountnonlocked=:accountnonlocked WHERE userId=:userId");
//		
//			query.setParameter("accountnonlocked", 0);
//			query.setParameter("userId", user.getUserId());
//
//			query.executeUpdate();
//			t.commit();
//
//		
//		}
//	}
//    
//    @Transactional
//	public void updateFailAttemptsCap(String username) {
//		UserLogin user = findByUsername(username);
//		System.out.println("user"+username+user.getAttempt_captcha_count());
//		if (user != null) {
//			Session s = sessionFactory.openSession();
//			Transaction t = s.beginTransaction();
//			Query query = s.createQuery(
//					"UPDATE UserLogin SET attempt_captcha_count=:attempt_captcha_count, cap_locked_date=:cap_locked_date WHERE userId=:userId");
//			query.setParameter("attempt_captcha_count", user.getAttempt_captcha_count() + 1);
//			query.setParameter("cap_locked_date", new Date());
//			query.setParameter("userId", user.getUserId());
//
//			query.executeUpdate();
//			t.commit();
//
//		}
//	}
//    
//    @Transactional
//	public void resetFailAttemptsCap(String username) {
//		UserLogin user = findByUsername(username);
//		if (user != null) {
//			Session s = sessionFactory.openSession();
//			Transaction t = s.beginTransaction();
//			Query query = s.createQuery(
//					"UPDATE UserLogin SET attempt_captcha_count=:attempt_captcha_count, cap_locked_date=:cap_locked_date,accountnonlocked=:accountnonlocked WHERE userId=:userId");
//			query.setParameter("attempt_captcha_count", 0);
//			query.setParameter("cap_locked_date", new Date());
//			query.setParameter("userId", user.getUserId());
//			query.setParameter("accountnonlocked", 1);
//			query.executeUpdate();
//			t.commit();
//
//		}
//
//	}
}