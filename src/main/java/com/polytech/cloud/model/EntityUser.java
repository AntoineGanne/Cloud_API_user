package com.polytech.cloud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Reference;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Document(collection = "users")
public class EntityUser {

    @Id
    private String id;

    @Field(value = "birthDay")
//    @NotEmpty(message = "Birthday is mandatory") //TODO: Vérification de (date non vide) ne marche pas.
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Past
    private Date birthDay;

    @Field(value = "firstName")
    @NotEmpty(message = "First name is mandatory")
    private String firstName;

    @Field(value = "lastName")
    @NotEmpty(message = "Last name is mandatory")
    private String lastName;

    @Valid
    @Field(value = "position")
    private Position position;

    // Static donc n'a pas accès aux informations de la classe encapsulante (EntityUser).
    public static class Position {

        @Field(value = "lat")
        @Range(min = -90, max = 90, message = "Position.latitude has to be within [-90,+90] range.")
        @NotNull(message = "Position.latitude is mandatory")
        private Double lat;

        @Field(value = "lon")
        @Range(min = -180, max = 180, message = "Position.longitude has to be within [-180,+180] range.")
        @NotNull(message = "Position.longitude is mandatory")
        private Double lon;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }
    }

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
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

