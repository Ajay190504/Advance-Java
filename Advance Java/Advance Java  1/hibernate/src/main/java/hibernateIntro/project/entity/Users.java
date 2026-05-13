package hibernateIntro.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    private int id;

    private String name;
    private String email;
    private String city;

    public Users() {}

    public Users(int id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    // getters & setters
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

    @Override
    public String toString() {
        return "User{id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
