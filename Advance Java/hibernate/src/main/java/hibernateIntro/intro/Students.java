package hibernateIntro.intro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "students")
public class Students {
	@Id
	private int stdId;
	private String stdName;
	private String stdCity;
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getName() {
		return stdName;
	}
	public void setName(String name) {
		this.stdName = name;
	}
	public String getCity() {
		return stdCity;
	}
	public void setCity(String city) {
		this.stdCity = city;
	}
	
	
}
