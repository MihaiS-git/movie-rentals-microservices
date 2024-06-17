package ubb.movierental.MovieEntity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import ubb.movierental.MovieEntity.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, QueryByExampleExecutor<Movie>,
        PagingAndSortingRepository<Movie, Long> {

}


