package com.polytech.cloud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Document(collection = "users")
public class EntityUser {

    @Id
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ObjectId id;

    @Field(value = "birthDay")
    private String birthDay;

    @Field(value = "firstName")
    private String firstName;

    @Field(value = "lastName")
    private String lastName;

    @Field(value = "position")
    private Map<String, Double> position;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) { this.id = id; }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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

    public Map<String, Double> getPosition() {
        return position;
    }

    public void setPosition(Map<String, Double> position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUser that = (EntityUser) o;

        if (!id.equals(that.id)) return false;
        if (!birthDay.equals(that.birthDay)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + birthDay.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }
}

