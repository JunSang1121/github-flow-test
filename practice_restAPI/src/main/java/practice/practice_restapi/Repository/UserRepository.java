package practice.practice_restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.practice_restapi.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
