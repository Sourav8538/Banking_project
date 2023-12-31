package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Customer {
	@Id
	@SequenceGenerator(initialValue = 2001,allocationSize =1,sequenceName = "custid",name="custid")
	@GeneratedValue(generator = "custid")
 long custid;
	
	String name;
	
	String email;
	
	long mob;
	
	Date dob;
	
	String gender;
	
	String password;
	
	@OneToMany
	List<Bankaccount>list;

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bankaccount> getList() {
		return list;
	}

	public void setList(List<Bankaccount> list) {
		this.list = list;
	}
	
}
