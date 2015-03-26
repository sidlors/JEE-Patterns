package com.sidlors.ejb;

import com.sidlors.ejb.local.SaludaEJBLocal;
import com.sidlors.ejb.remote.SaludaEJBRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludaEJB
 */
@Stateless
@LocalBean
public class SaludaEJB implements SaludaEJBRemote, SaludaEJBLocal {

	@Override
	public String saludaMundo(String nombre) {

		return "Hola "+nombre;
	}

  

}
