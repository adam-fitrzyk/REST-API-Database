package org.example.springboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    public String _id;
    public String user;
    public String workstation;

    public User() {}

    public User(String user, String workstation) {
        this.user = user;
        this.workstation = workstation;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, user=%s, workstation=%s]",
                _id, user, workstation
        );
    }

}
