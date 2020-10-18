package cn.edu.sau.web.UserInfo;

public class UserInfo {
	private String name;
	private String key;
	private String telephone;
	private String email;
	private String sex;
	private String hobby;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getkey() {
		return key;
	}

	public void setkey(String key) {
		this.key = key;
	}

	public void setrename(String rename) {
		this.name = rename;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return telephone;
	}

	public void setTelphone(String telphone) {
		this.telephone = telphone;
	}

	public String gethobby() {
		return hobby;
	}

	public void sethobby(String hobby) {
		this.hobby = hobby;
	}

}
