package se.joafre.worplace.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by joanne on 10/12/15.
 */
@Embeddable
public class ParkingSpot {

    @Column(nullable = false)
    private Long parkingId;
    @Column(nullable = false)
    private String label;

    protected ParkingSpot() {}

    public ParkingSpot(Long parkingId, String label) {
        this.parkingId = parkingId;
        this.label = label;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public String getLabel() {
        return label;
    }
}
