package com.sidlors.ejb.local;

import javax.ejb.Local;

@Local
public interface SaludaEJBLocal {
	
	public String saludaMundo(String nombre);

}
