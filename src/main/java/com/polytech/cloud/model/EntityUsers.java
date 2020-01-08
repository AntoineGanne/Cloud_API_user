package com.polytech.cloud.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "btokuuvbmabzcox", catalog = "")
public class EntityUsers {
    private String id;
    private String birthDay;
    private String firstName;
    private String lastName;
    private Object position;
    private Double positionLat;
    private Double positionLon;

    @Id
    @Column(name = "_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "birthDay")
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "position")
    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    @Basic
    @Column(name = "position.lat")
    public Double getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(Double positionLat) {
        this.positionLat = positionLat;
    }

    @Basic
    @Column(name = "position.lon")
    public Double getPositionLon() {
        return positionLon;
    }

    public void setPositionLon(Double positionLon) {
        this.positionLon = positionLon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUsers that = (EntityUsers) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(birthDay, that.birthDay) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(position, that.position) &&
                Objects.equals(positionLat, that.positionLat) &&
                Objects.equals(positionLon, that.positionLon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthDay, firstName, lastName, position, positionLat, positionLon);
    }
}
