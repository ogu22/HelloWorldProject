package info.helloworld.sbmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.helloworld.sbmt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
