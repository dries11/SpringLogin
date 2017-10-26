package ries.dan.Model;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    private Integer id;

    @Column
    private String latitude;

    @Column
    private String longitude;

    public Location(){}

    public Location(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
