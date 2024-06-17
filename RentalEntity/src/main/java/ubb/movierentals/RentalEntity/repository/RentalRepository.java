package ubb.movierentals.RentalEntity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import ubb.movierentals.RentalEntity.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>, QueryByExampleExecutor<Rental>,
        PagingAndSortingRepository<Rental, Long> {

}
