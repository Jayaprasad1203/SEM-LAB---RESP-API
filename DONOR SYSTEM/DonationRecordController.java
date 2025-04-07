package third.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import third.demo.entity.DonationRecord;
import third.demo.entity.Donor;
import third.demo.service.DonationRecordService;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class DonationRecordController {

    @Autowired
    private DonationRecordService donationRecordService;

    @GetMapping
    public List<DonationRecord> getAllDonors() {
        return donationRecordService.getAllDonorsRecords();
    }
    @PostMapping
    public ResponseEntity<DonationRecord> addRecord(@RequestBody DonationRecord record) {
        return ResponseEntity.ok(donationRecordService.saveRecord(record));
    }

    @GetMapping("/donor/{donorId}")
    public List<DonationRecord> getByDonor(@PathVariable Long donorId) {
        return donationRecordService.getRecordsByDonorId(donorId);
    }
}

