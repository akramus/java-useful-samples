package fr.adiveo.samples.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.StringJoiner;

@Entity
@NamedQueries({ @NamedQuery(name = "Role.findAll", query = "SELECT p FROM Role p") })
public class Role {

    @Id
    @Column(name = "ID_ROLE")
    private String idRole;

    @Column(name = "NAME")
    private String name;

    public Role() {
        // Default
    }

    public String getIdRole() {
        return this.idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
                .add("idRole='" + idRole + "'")
                .add("name='" + name + "'")
                .toString();
    }
}