package postgresWS.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import postgresWS.Models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>
{

}
