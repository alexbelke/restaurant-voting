package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

	@Column(name = "email", nullable = false, unique = true)
	@Email
	@NotBlank
	@Size(max = 100)
	private String email;

	@Column(name = "password", nullable = false)
	@NotBlank
	@Size(min = 5, max = 100)
	private String password;

	@Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
	private boolean enabled = true;

	@Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
	@NotNull
	private Date registered = new Date();

	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles;
}
