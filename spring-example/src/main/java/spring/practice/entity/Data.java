package spring.practice.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="DATE_CREATED")
	Timestamp date_create;
	
	protected Data() {}

    public Data(String name, String email) {
        this.name = name;
        this.email = email;
        this.date_create = new Timestamp(System.currentTimeMillis());
    }

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", email=" + email + ", date_create=" + date_create + "]";
	}
    
    
}
