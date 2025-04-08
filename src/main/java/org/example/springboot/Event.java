package org.example.springboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {

    @Id
    public String _id;
    public String type;
    public double time;
    public String user;
    public String ip;

    public Event() {}

    public Event(String type, double time, String user, String ip) {
        this.type = type;
        this.time = time;
        this.user = user;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return String.format(
                "Event[id=%s, type=%s, time=%.0f, user=%s, ip=%s]",
                _id, type, time, user, ip
        );
    }

}
