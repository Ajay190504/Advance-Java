package hibernateIntro.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity 
// @Cacheable : for second level cache -- access for entire session factory
@Table (name = "students")
public class Students {
	@Id
	private int stId;
	
	@Column (name="stName")
	private String stName;
	
	@Column (name="stCity")
	private String stCity;
	
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStCity() {
		return stCity;
	}
	public void setStCity(String stCity) {
		this.stCity = stCity;
	}
	@Override
	public String toString() {
		return "Students [stId=" + stId + ", stName=" + stName + ", stCity=" + stCity + "]";
	}
	
	
}
