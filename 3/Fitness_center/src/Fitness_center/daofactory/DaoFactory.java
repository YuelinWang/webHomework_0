package Fitness_center.daofactory;

import Fitness_center.dao.InstructorDao;

public interface DaoFactory {
	public InstructorDao createInstructorDao();
}
