package net.sl.entity;

import javax.persistence.*;

/**
 * Created by a601054 on 2015-08-20.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    @Column
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
