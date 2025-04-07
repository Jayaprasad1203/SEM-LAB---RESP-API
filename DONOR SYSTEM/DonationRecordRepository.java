package third.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import third.demo.entity.DonationRecord;

import java.util.List;

public interface DonationRecordRepository extends JpaRepository<DonationRecord, Long> {
    List<DonationRecord> findByDonorId(Long donorId);
}

