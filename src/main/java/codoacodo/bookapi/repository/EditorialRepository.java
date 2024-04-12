package codoacodo.bookapi.repository;


import codoacodo.bookapi.models.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository  extends JpaRepository<Editorial, Long> {
}
