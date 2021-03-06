package ma.emsi.miage3.ecommerce.dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface GenericDAO {
  public Object add(Object object);
  public boolean delete(Object object);
  public Object update(Object object);
  public Object findByID(Class entity, Integer id);
  public EntityManager getEntityManager();

}
