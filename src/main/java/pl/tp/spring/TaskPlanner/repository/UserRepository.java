package pl.tp.spring.TaskPlanner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tp.spring.TaskPlanner.domain.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select case when count(u) = 0 then true else false end from User u where u.username = ?1")
    boolean isUsernameFree(String username);

    User findByUsername(String username);
}
