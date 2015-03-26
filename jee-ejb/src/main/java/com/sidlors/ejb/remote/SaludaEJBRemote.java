package com.sidlors.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface SaludaEJBRemote {
	
	
	public String saludaMundo(String nombre);

}
