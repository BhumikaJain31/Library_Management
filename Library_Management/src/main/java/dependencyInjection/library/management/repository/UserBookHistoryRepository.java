package dependencyInjection.library.management.repository;

import dependencyInjection.library.management.entity.UserBookHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserBookHistoryRepository extends CrudRepository<UserBookHistoryEntity, Integer> {
}
