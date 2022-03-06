package com.codegym.repository;

import com.codegym.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Music> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<Music> musicList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            musicList = session.createQuery("FROM Music ").getResultList();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
        return musicList;    }

    @Override
    public void save(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(music);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public Music findById(Long id) {
        String stringQuery = "select m from Music as m where m.id = :id";
        Music music = new Music();
        try {
            TypedQuery<Music> typedQuery = entityManager.createQuery(stringQuery,Music.class);
            typedQuery.setParameter("id",id);
            music = typedQuery.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return music;
    }

    @Override
    public void update(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music music1 = findById(music.getId());
            music1.setName(music1.getName());
            music1.setSinger(music1.getSinger());
            music1.setSongType(music1.getSongType());
            music1.setSongPath(music1.getSongPath());
            session.saveOrUpdate(music1);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void remove(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music music = findById(id);
            session.remove(music);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
