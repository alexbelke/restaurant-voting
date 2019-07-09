package model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
	@Column(name = "number")
	@Range(min = 1, max = 5)
	@NotNull
	private int number;

	@Column(name = "date_time")
	@NotNull
	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	@NotNull
	private Restaurant restaurant;

	public Vote() {
	}

	public Vote(@Range(min = 1, max = 5) @NotNull int number, @NotNull LocalDateTime dateTime, @NotNull User user, @NotNull Restaurant restaurant) {
		this(null, number, dateTime, user, restaurant);
	}

	public Vote(Integer id, @Range(min = 1, max = 5) @NotNull int number, @NotNull LocalDateTime dateTime, @NotNull User user, @NotNull Restaurant restaurant) {
		super(id);
		this.number = number;
		this.dateTime = dateTime;
		this.user = user;
		this.restaurant = restaurant;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Vote{" +
			"number=" + number +
			", dateTime=" + dateTime +
			", user=" + user +
			", restaurant=" + restaurant +
			", id=" + id +
			'}';
	}
}
