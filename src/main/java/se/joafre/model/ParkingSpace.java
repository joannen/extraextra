package se.joafre.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParkingSpace {

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String parkingLabel;

    protected ParkingSpace() {}

    public ParkingSpace(Long id, String parkingLabel) {
        this.id = id;
        this.parkingLabel = parkingLabel;
    }

    public Long getId() {
        return id;
    }

    public String getParkingLabel() {
        return parkingLabel;
    }
}
