package org.example.springboot;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EventRepository extends MongoRepository<Event, String> {

    public List<Event> findByType(String type);
    public List<Event> findByTime(int time);
    public List<Event> findByUser(String user);
    public List<Event> findByIp(String ip);

    @Query("?0")
    public List<Event> findByFilter(String filter);

}
