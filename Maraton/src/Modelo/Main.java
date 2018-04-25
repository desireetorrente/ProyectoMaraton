package Modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistencia.AdministradoresHome;
import persistencia.UsuariosHelper;


public class Main {

	
	public static void main(String[] args) {
		UsuariosHelper helper = new UsuariosHelper();
		System.out.println(helper.search(555).getDniUsuarios());
	}

}
