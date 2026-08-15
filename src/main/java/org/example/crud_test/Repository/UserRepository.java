package org.example.crud_test.Repository;

import org.example.crud_test.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByName(String name);
}
