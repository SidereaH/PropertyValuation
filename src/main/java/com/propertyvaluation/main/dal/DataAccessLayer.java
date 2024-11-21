package com.propertyvaluation.main.dal;

import com.propertyvaluation.main.models.*;

import java.util.List;

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
  /*
   * public List<Position> getAllPositions() {
   * List<Position> positions = null;
   * 
   * try (Session session = sessionFactory.openSession()) {
   * session.beginTransaction();
   * positions = session.createQuery("FROM Position", Position.class).list();
   * session.getTransaction().commit();
   * } catch (Exception e) {
   * e.printStackTrace();
   * }
   * 
   * return positions;
   * }
   * 
   * public Position getPosition(Long id) {
   * Position position = null;
   * 
   * try (Session session = sessionFactory.openSession()) {
   * session.beginTransaction();
   * position = session.get(Position.class, id);
   * session.getTransaction().commit();
   * } catch (Exception e) {
   * e.printStackTrace();
   * }
   * return position;
   * }
   */
  // Appraisal CRUD Operations

  public void createAppraisal(Appraisal appraisal) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(appraisal);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public Appraisal readAppraisal(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Appraisal.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updateAppraisal(Appraisal appraisal) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(appraisal);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deleteAppraisal(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Appraisal appraisal = session.get(Appraisal.class, id);
      if (appraisal != null) {
        session.remove(appraisal);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createAppraisalType(AppraisalType appraisalType) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(appraisalType);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public AppraisalType readAppraisalType(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(AppraisalType.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updateAppraisalType(AppraisalType appraisalType) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(appraisalType);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deleteAppraisalType(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      AppraisalType appraisalType = session.get(AppraisalType.class, id);
      if (appraisalType != null) {
        session.remove(appraisalType);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }

  }

  public void createClient(Client client) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(client);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public Client readClient(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Client.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updateClient(Client client) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(client);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deleteClient(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Client client = session.get(Client.class, id);
      if (client != null) {
        session.remove(client);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createContract(Contract contract) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(contract);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public Contract readContract(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Contract.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updateContract(Contract contract) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(contract);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deleteContract(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Contract contract = session.get(Contract.class, id);
      if (contract != null) {
        session.remove(contract);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createEmployee(Employees employee) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(employee);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public Employees readEmployee(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Employees.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updateEmployee(Employees employee) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(employee);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deleteEmployee(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Employees employee = session.get(Employees.class, id);
      if (employee != null) {
        session.remove(employee);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createPosition(Position position) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(position);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public Position readPosition(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Position.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updatePosition(Position position) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(position);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deletePosition(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Position position = session.get(Position.class, id);
      if (position != null) {
        session.remove(position);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createPropertyObject(PropertyObject propertyObject) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(propertyObject);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public PropertyObject readPropertyObject(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(PropertyObject.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updatePropertyObject(PropertyObject propertyObject) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(propertyObject);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deletePropertyObject(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      PropertyObject propertyObject = session.get(PropertyObject.class, id);
      if (propertyObject != null) {
        session.remove(propertyObject);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void createPropertyType(PropertyTypes propertyType) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.persist(propertyType);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public PropertyTypes readPropertyType(Long id) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(PropertyTypes.class, id);
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void updatePropertyType(PropertyTypes propertyType) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.merge(propertyType);
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  public void deletePropertyType(Long id) {
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      PropertyTypes propertyType = session.get(PropertyTypes.class, id);
      if (propertyType != null) {
        session.remove(propertyType);
      }
      session.getTransaction().commit();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }
}
