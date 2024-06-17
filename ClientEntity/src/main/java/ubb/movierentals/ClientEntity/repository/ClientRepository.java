package ubb.movierentals.ClientEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import ubb.movierentals.ClientEntity.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, QueryByExampleExecutor<Client>,
        PagingAndSortingRepository<Client, Long> {

}
