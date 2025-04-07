package third.demo.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DonationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate donationDate;
    private String location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id") // Many Events belong to One User
    @JsonBackReference
    private Donor donor;

    // Constructors
    public DonationRecord() {}

    public DonationRecord(LocalDate donationDate, String location, Donor donor) {
        this.donationDate = donationDate;
        this.location = location;
        this.donor = donor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
}

