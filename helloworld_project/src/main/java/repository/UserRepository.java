package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

}
