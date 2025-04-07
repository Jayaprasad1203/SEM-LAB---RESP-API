package third.demo.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String bloodGroup;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DonationRecord> donationRecords;


    // Constructors
    public Donor() {}

    public Donor(String name, int age, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<DonationRecord> getDonationRecords() {
        return donationRecords;
    }

    public void setDonationRecords(List<DonationRecord> donationRecords) {
        this.donationRecords = donationRecords;
    }
}
