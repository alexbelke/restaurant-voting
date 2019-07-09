package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

	private String description;
	private List<Vote> votes;

	public Restaurant() {
	}

	public Restaurant(String name, String description, List<Vote> votes) {
		this(null, name, description, votes);

	}

	public Restaurant(Integer id, String name, String description, List<Vote> votes) {
		super(id, name);
		this.votes = votes;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Restaurant{" +
			"description='" + description + '\'' +
			", votes=" + votes +
			", name='" + name + '\'' +
			", id=" + id +
			'}';
	}
}
