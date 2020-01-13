package com.polytech.cloud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Reference;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Document(collection = "users")
public class EntityUser {

    @Id
//    @Reference
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    @Field(value = "birthDay")
//    @NotEmpty(message = "Birthday is mandatory") //TODO: Vérification de la date non vide.
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date birthDay;

    @Field(value = "firstName")
    @NotEmpty(message = "First name is mandatory")
    private String firstName;

    @Field(value = "lastName")
    @NotEmpty(message = "Last name is mandatory")
    private String lastName;

    @Field(value = "position")
//    @NotEmpty(message = "Position is mandatory") //TODO: Vérification de la position non vide.
    private Map<String, Double> position;

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
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

