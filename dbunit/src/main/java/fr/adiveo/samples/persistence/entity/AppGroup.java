package fr.adiveo.samples.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "APP_GROUP")
@NamedQuery(name = "AppGroup.findAll", query = "SELECT g FROM AppGroup g")
public class AppGroup {

    @Id
    @Column(name = "ID_GROUP")
    private String idGroup;

    private String name;

    // bi-directional many-to-many association to Role
    @ManyToMany
    @JoinTable(name = "APP_GROUP_ROLE", joinColumns = { @JoinColumn(name = "ID_GROUP") }, inverseJoinColumns = {
            @JoinColumn(name = "ID_ROLE") })
    private List<Role> roles;

    public AppGroup() {
        // Default
    }

    public AppGroup(String idGroup, String name) {
        this.idGroup = idGroup;
        this.name = name;
    }

    public String getIdGroup() {
        return this.idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        if(null == this.roles) {
            this.roles = new ArrayList<>();
        }
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AppGroup.class.getSimpleName() + "[", "]")
                .add("idGroup='" + idGroup + "'")
                .add("name='" + name + "'")
                .add("roles=" + roles)
                .toString();
    }
}