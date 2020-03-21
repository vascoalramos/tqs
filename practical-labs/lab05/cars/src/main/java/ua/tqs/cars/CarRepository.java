package ua.tqs.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 15:49
 */

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);
}