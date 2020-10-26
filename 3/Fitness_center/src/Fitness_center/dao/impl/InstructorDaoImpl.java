package Fitness_center.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Fitness_center.dao.InstructorDao;
import Fitness_center.utils.DBUtil;
import Fitness_center.vo.InstructorVo;
import page.ListPage;


public class InstructorDaoImpl implements InstructorDao {

	private int count = 0;
	@Override
	public void insert(InstructorVo data) throws Exception {
		// TODO Auto-generated method stub
		DBUtil dbu=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		String msg="";
		try{
			if(data==null) {throw new Exception("插入数据为空");}
	        dbu=new DBUtil();
	        Connection con=dbu.getConnection();
	        //System.out.println(data.getcharacter());
			String sql="insert into instructors values(?,?,?,?,?,?,?,?,?,?)";
	        ps=con.prepareStatement(sql);
	        ps.setString(1, data.getrname());
	        ps.setString(2, data.getrpass());
	        ps.setString(3, data.getsex());
	        ps.setString(4, data.getdate());
	        ps.setString(5, data.getemail());
	        ps.setString(6, data.gettel());
	        ps.setString(7, data.getcharacter());
	        ps.setString(8, data.getgrade());
	        ps.setString(9, data.gethobby());
	        ps.setString(10, data.getpersonal());
	        int rows=ps.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(ps!=null){
				ps.close();
			}	
			if(rs!=null) {
				rs.close();
			}
		}
		
	}

	@Override
	public void delete(String delstr) throws Exception {
		// TODO Auto-generated method stub
		DBUtil dbu = null;
        PreparedStatement ps = null;
        try {
            if (delstr == null||delstr.trim().equals("")) {
                throw new Exception("删除的用户数据为空！");
            }
            dbu = new DBUtil();
            Connection con = dbu.getConnection();
            ps = con.prepareStatement("delete from instructors where "+delstr);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            dbu.commit(ps);
        }
	}


	@Override
	public void update(String oldUname, InstructorVo data) throws Exception {
		// TODO Auto-generated method stub
		DBUtil dbu = null;
        PreparedStatement ps = null;
        try {
            if (oldUname == null) {
                throw new Exception("待修改的用户名为空！");
            }
            if (data == null) {
                throw new Exception("修改的用户数据为空！");
            }
            dbu = new DBUtil();
            Connection con = dbu.getConnection();
            ps = con.prepareStatement("update instructors set rname=?,rpass=?,sex=?,birthday=?,email=?,phone=?,"
            		+ "urole=?,grade=?,hobby=?,instroduction=? where rname=?");
            ps.setString(1, data.getrname());
            ps.setString(2, data.getrpass());
            ps.setString(3, data.getsex());
            ps.setString(4, data.getdate());
            ps.setString(5, data.getemail());
            ps.setString(6, data.gettel());
            ps.setString(7,data.getcharacter());
            ps.setString(8,data.gethobby());
            ps.setString(9, data.getpersonal());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            dbu.commit(ps);
        }
		
	}
	@Override
	public InstructorVo getTUser(String rname) throws Exception {
		// TODO Auto-generated method stub
		DBUtil dbu = null;
		PreparedStatement ps = null;
		InstructorVo user = null;
		try {
			if (rname == null) {
				throw new Exception("查找的用户名为空！");
			}
			dbu = new DBUtil();
			Connection con = dbu.getConnection();
			ps = con.prepareStatement("select rname,rpass,sex,birthday,email,phone,"
					+ "urole,grade,hobby,instroduction from instructors where uname=?");
			ps.setString(1, rname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = this.getObjectFromResult(rs);
			}
		} catch (Exception e) {
			throw e;
		} finally {
		}
		return user;
	}


	private InstructorVo getObjectFromResult(ResultSet rs) {
		// TODO Auto-generated method stub
		InstructorVo user = new InstructorVo();
        try {
        	
        	user.setrname(rs.getString("rname"));
			user.setrpass(rs.getString("rpass"));
			user.setsex(rs.getString("sex"));
			user.setdate(rs.getString("birthday"));
			user.setemail(rs.getString("email"));
			user.settel(rs.getString("phone"));
			user.setcharacter(rs.getString("urole"));
			user.setgrade(rs.getString("grade"));
			user.sethobby(rs.getString("hobby"));
			user.setpersonal(rs.getString("introduction"));
        } catch (Exception e) {
            user = null;
        }
        System.out.println(user.getrname());
        return user;
        
	}



	@Override
	public ListPage list() {
		// TODO Auto-generated method stub
		return this.list(-1, -1, null);
	}


	@Override
	public ListPage list(String wstr) {
		// TODO Auto-generated method stub
		return this.list(-1, -1, wstr);
	}


	@Override
	public ListPage list(int beginIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.list(beginIndex, pageSize, null);
	}


	@Override
	public ListPage list(int beginIndex, int pageSize, String wstr) {
		// TODO Auto-generated method stub
		DBUtil dbu = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ListPage listPage=new ListPage();
        List<InstructorVo> list = new ArrayList<InstructorVo>();
        try {
            String sql = "select * from instructors";
            dbu = new DBUtil();
            Connection con = dbu.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            if (beginIndex <= 0) {
                beginIndex = 1;
            }
            int i = 0;
            int len = pageSize;
            boolean page=true;
            if (len < 1)//获取全部数据
            {
                len = count;
                page=false;
            }
            if (rs.absolute(beginIndex)) {
                do {
                	InstructorVo tmp = this.getObjectFromResult(rs);
                    list.add(tmp);
                    i++;
                    if (i == len) {
                        break;
                    }
                } while (rs.next());
            }
        //上一页开始记录索引
           Integer preIndex = beginIndex - pageSize;
            if (preIndex < 0) {
                preIndex = 0;
            }
            //下一页开始记录索引	
            Integer nextIndex = beginIndex + list.size();
            if (nextIndex > count) {
                nextIndex = count;
            }

            listPage.setBeginIndex(beginIndex);
            listPage.setCount(count);
            listPage.setListData(list);
            listPage.setNextIndex(nextIndex);
            listPage.setPageSize(pageSize);
            listPage.setPreIndex(preIndex);
            listPage.setPage(page);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbu.commit(ps, rs);
        }
        return listPage;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}
	
}
