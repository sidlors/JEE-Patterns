
 package com.sidlors.daos.impl;
 
 
 import com.sidlors.daos.RolDAO;
 import java.io.Serializable;
 import com.sidlors.daos.customdaosupport.CustomDAOSupport;
 import javax.persistence.Query;
 import java.util.List;
 import com.sidlors.entities.Rol;
 import java.math.BigDecimal;
 
 
 public class RolDAOImpl extends CustomDAOSupport<Rol, Long>  implements Serializable, RolDAO {
 
 
	public RolDAOImpl(){
		super( Rol.class);
	}
 
 /**
 * @return Rol
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public List<Rol> findAll(){

		Query query = getDAOManager().createQuery(" select t from Rol t");

		List<Rol> results = query.getResultList();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * Inserts Rol
 * @param: Rol
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public void save(Rol arg0){

		getDAOManager().persist(arg0);

	}
 
 /**
 * Updates Rol
 * @param: Rol
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public void update(Rol arg0){

		getDAOManager().merge(arg0);

	}
 
 /**
 * Removes Rol
 * @param: Rol
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public void delete(Rol arg0){

		getDAOManager().remove(arg0);

	}
 
 /**
 * @return Rol
 * @param: java.math.BigDecimal Id
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public List<Rol> getRolById(BigDecimal id){

		Query query = getDAOManager().createQuery(" select t from Rol t where t.id = ?1 ");

		query.setParameter(1, id);


		List<Rol> results = query.getResultList();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Rol
 * @param: java.math.BigDecimal id
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sun Mar 29 10:36:48 CST 2015
 * @See Rol
 */
	public List<Rol> getRolById(BigDecimal id, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Rol t where t.id = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, id);


		List<Rol> results = query.getResultList();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 
 
 
 }