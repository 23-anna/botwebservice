package utm.pr.botwebservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utm.pr.botwebservice.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
