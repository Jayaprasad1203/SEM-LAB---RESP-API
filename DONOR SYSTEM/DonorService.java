package third.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import third.demo.entity.DonationRecord;
import third.demo.entity.Donor;
import third.demo.repository.DonorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public Donor saveDonor(Donor donor) {
        // Set the donor in each donation record (Bidirectional mapping)
        if (donor.getDonationRecords() != null) {
            for (DonationRecord record : donor.getDonationRecords()) {
                record.setDonor(donor);
            }
        }

        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }

    public List<Donor> findByBloodGroup(String bloodGroup) {
        return donorRepository.findByBloodGroup(bloodGroup);
    }

    public Page<Donor> getDonorsSortedByAge(int page, int size) {
        return donorRepository.findAllSortedByAge(PageRequest.of(page, size));
    }
}
