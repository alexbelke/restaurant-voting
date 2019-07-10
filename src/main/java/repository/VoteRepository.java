package repository;

import model.Vote;

import java.util.List;

public interface VoteRepository {

	Vote save(Vote vote);

	// false if not found
	boolean delete(int id);

	// null if not found
	Vote get(int id);

	// null if not found
	List<Vote> getByUserId(int userId);

	List<Vote> getByRestaurantId(int restaurantId);

	List<Vote> getAll();
}
