package fr.adiveo.samples.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "USER")
@NamedQuery(name = "User.findAll", query = "SELECT a FROM User a")
public class User {

    @Id
    private String id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CONNECTION_DATE")
    private LocalDateTime connectionDate;

    // bi-directional many-to-many association to Role
    @ManyToMany
    @JoinTable(name = "USER_APP_GROUP", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ID_GROUP") })
    private List<AppGroup> appGroups;

    public User() {
        // Default
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime c() {
        return this.connectionDate;
    }

    public void setConnectionDate(LocalDateTime connectionDate) {
        this.connectionDate = connectionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getConnectionDate() {
        return connectionDate;
    }

    public List<AppGroup> getAppGroups() {
        if(null == this.appGroups) {
            this.appGroups = new ArrayList<>();
        }
        return this.appGroups;
    }

    public void setAppGroups(List<AppGroup> appGroups) {
        this.appGroups = appGroups;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("connectionDate=" + connectionDate)
                .add("appGroups=" + appGroups)
                .add("c=" + c())
                .toString();
    }
}