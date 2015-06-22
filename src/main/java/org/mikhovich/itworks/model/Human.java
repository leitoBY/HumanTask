package org.mikhovich.itworks.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/** Class Human */

@Entity
@Table (name = "Humans")
public class Human {
	
	@Id
	@Column (name ="humanId")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int humanId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String login;
	private String password;
	
	
	public Human() {
		super();
	}
	
	public Human(String firstName, String lastName, String middleName, String login, String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	
	public int getHumanId() {
		return humanId;
	}

	public void setHumanId(int humanId) {
		this.humanId = humanId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "human", fetch = FetchType.LAZY)
    private List<Task> tasksList = new ArrayList<Task>();

	public List<Task> getTasksList() {
		return tasksList;
	}
	public void setTasksList(List<Task> tasksList) {
		this.tasksList = tasksList;
	}

}
