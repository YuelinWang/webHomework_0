package cn.edu.sau.web.dao;

import cn.edu.sau.web.UserInfo.UserInfo;

public interface SQLDAO {
	public String select();
    public String selectWay(String way,String input);
    public String insert(UserInfo userInfo);
}
