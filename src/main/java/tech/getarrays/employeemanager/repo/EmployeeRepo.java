package tech.getarrays.employeemanager.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.id=:id")
    void deleteEmployeeById(@Param("id") Long id);

    Optional<Employee> findEmployeeById(Long id);
}
