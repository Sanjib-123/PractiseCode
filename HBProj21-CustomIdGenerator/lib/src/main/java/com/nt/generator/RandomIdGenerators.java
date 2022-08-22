package com.nt.generator;

import java.io.Serializable;
//import java.sql.Connection;
import java.util.Random;

import org.hibernate.HibernateException;
//import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerators implements IdentifierGenerator {
	
	public RandomIdGenerators() {
		System.out.println("RandomIdGenerators.RandomIdGenerators()");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("RandomIdGenerators.generate()");
		//Connection con = session.connection();
		int idVal = new Random().nextInt(20000);
		return idVal;
	}

}
