package third.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import third.demo.entity.Donor;
import third.demo.service.DonorService;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        return ResponseEntity.ok(donorService.saveDonor(donor));
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        return donorService.getDonorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/blood-group/{group}")
    public List<Donor> getByBloodGroup(@PathVariable String group) {
        return donorService.findByBloodGroup(group);
    }

    @GetMapping("/sorted-by-age")
    public Page<Donor> getSortedByAge(@RequestParam int page, @RequestParam int size) {
        return donorService.getDonorsSortedByAge(page, size);
    }
}
