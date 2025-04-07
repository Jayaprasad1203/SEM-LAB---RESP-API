package third.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import third.demo.entity.Donor;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    List<Donor> findByBloodGroup(String bloodGroup);

    @Query("SELECT d FROM Donor d ORDER BY d.age ASC")
    Page<Donor> findAllSortedByAge(Pageable pageable);
}
