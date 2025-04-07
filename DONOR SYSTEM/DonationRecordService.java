package third.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import third.demo.entity.DonationRecord;
import third.demo.entity.Donor;
import third.demo.repository.DonationRecordRepository;
import third.demo.repository.DonorRepository;

import java.util.List;

@Service
public class DonationRecordService {

    @Autowired
    private DonationRecordRepository donationRecordRepository;

    @Autowired
    private DonorRepository donorRepository;

    public DonationRecord saveRecord(DonationRecord record) {
        if (record.getDonor() != null) {
            Long donorId = record.getDonor().getId();
            Donor donor = donorRepository.findById(donorId)
                    .orElseThrow(() -> new IllegalArgumentException("Donor not found with ID: " + donorId));
            record.setDonor(donor);
        } else {
            throw new IllegalArgumentException("Donor must be provided");
        }

        return donationRecordRepository.save(record);
    }

    public List<DonationRecord> getAllDonorsRecords() {
        return donationRecordRepository.findAll();
    }
    public List<DonationRecord> getRecordsByDonorId(Long donorId) {
        return donationRecordRepository.findByDonorId(donorId);
    }
}
