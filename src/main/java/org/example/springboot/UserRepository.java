package org.example.springboot;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUser(String user);
    public User findByWorkstation(String workstation);

    @Query("?0")
    public List<User> findByFilter(String filter);

}
