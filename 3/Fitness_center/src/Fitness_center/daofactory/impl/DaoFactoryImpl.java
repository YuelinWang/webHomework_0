package Fitness_center.daofactory.impl;

import Fitness_center.dao.InstructorDao;
import Fitness_center.dao.impl.InstructorDaoImpl;
import Fitness_center.daofactory.DaoFactory;

public class DaoFactoryImpl implements DaoFactory {

	//public DaoFactoryImpl() {};
	@Override
	public InstructorDao createInstructorDao() {
		// TODO Auto-generated method stub
		InstructorDaoImpl mrg = null;
        try {
            mrg = new InstructorDaoImpl();
        } catch (Exception e) {   }
        return mrg;
	}
}
