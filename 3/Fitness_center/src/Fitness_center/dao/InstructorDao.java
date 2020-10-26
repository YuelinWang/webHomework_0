package Fitness_center.dao;

import Fitness_center.vo.InstructorVo;
import page.ListPage;

public interface InstructorDao {
	public void insert(InstructorVo data) throws Exception;
	public void delete(String delstr) throws Exception;
    public void update(String oldUname,InstructorVo data) throws Exception;
    public InstructorVo getTUser(String rname) throws Exception;
    public ListPage list();
    public ListPage list(String wstr);
    public ListPage list(int beginIndex,int pageSize);
    public ListPage list(int beginIndex,int pageSize,String wstr);
    public int getCount();

}
