package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo {

 public static void main(String[] args) {

  Configuration cfg = new Configuration();
  cfg.configure("hibernate.cfg.xml");

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();

  Transaction tx = session.beginTransaction();

  Movie m = new Movie();
  m.setId(1);
  m.setName("RRR");
  m.setDate("2024");
  m.setStatus("Released");

  session.save(m);

  Query q = session.createQuery("update Movie set name=?1,status=?2 where id=?3");
  q.setParameter(1,"Pushpa");
  q.setParameter(2,"Upcoming");
  q.setParameter(3,1);

  q.executeUpdate();

  tx.commit();

  session.close();
  sf.close();

 }

}
