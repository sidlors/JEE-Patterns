package com.certificatic.practica1.ejb;

import com.certificatic.practica1.ejb.local.SaludaEJBLocal;
import com.certificatic.practica1.ejb.remote.SaludaEJBRemote;

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
