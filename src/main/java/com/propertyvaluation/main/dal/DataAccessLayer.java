package com.propertyvaluation.main.dal;

import com.propertyvaluation.main.models.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Component;

import com.propertyvaluation.main.models.Employees;

@Component
public class DataAccessLayer {
  private SessionFactory sessionFactory;

  public DataAccessLayer(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  Session session = null;

  public void createEmployee(Employees employee) {
    session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(employee);
    session.getTransaction().commit();
    if (session != null) {
      session.close();
    }
  }

  public void createPosition(Position position) {
    session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(position);
    session.getTransaction().commit();
    if (session != null) {
      session.close();
    }
  }

  public List<Position> getAllPositions() {
    List<Position> positions = null;

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      positions = session.createQuery("FROM Position", Position.class).list();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return positions;
  }

  public Position getPosition(Long id) {
    Position position = null;

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      position = session.get(Position.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return position;
  }
}
