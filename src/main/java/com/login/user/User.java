package com.login.user;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="UserData")


public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	  private long id;
	  private @NotBlank String username;
	  private @NotBlank String password;
	 private @NotBlank boolean loggedIn;

	  public User() {
	  }

	  public User(@NotBlank String username, 
              @NotBlank String password) {
      this.username = username;
      this.password = password;
    this.loggedIn = false;
  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	  public boolean isLoggedIn() { return loggedIn; }
	  
	  public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }
	 
	
	@Override
	 public boolean equals(Object o) {
		if(this == o) return true;
		if (!(o instanceof User)) return false;
		 User user = (User) o;
	        return Objects.equals(username, user.username) &&
	                Objects.equals(password, user.password);
	    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, 
                           loggedIn);
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", loggedIn=" + loggedIn + "]";
	}

	
   
		
	}




