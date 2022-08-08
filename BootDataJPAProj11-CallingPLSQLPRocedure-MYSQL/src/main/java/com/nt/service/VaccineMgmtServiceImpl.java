package com.nt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;

@Service("vaccineService")
public class VaccineMgmtServiceImpl implements IVaccineMgmtService {
@Autowired
private EntityManager manager;

	@Override
	public List<CoronaVaccine> searchVaccineByPriceRange(double min, double max) {
		//create StoredProcedure obj reperesenting our PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICERANGE",CoronaVaccine.class);
		
		//register parameters of pl/sql procedure
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,CoronaVaccine.class,ParameterMode.OUT);
		
		//set values to parameter
		query.setParameter(1, min);
		query.setParameter(2, max);
		//query.setParameter(1, min);
		//call PL/SQL procedure
		List<CoronaVaccine>list = query.getResultList();
		
		
		return list;
	}

}
