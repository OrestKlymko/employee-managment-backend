package net.java.backend.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "email_id", nullable = false)
	private String email;
}
