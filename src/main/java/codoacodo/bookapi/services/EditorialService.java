package codoacodo.bookapi.services;

import codoacodo.bookapi.models.Editorial;
import codoacodo.bookapi.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {
    @Autowired
    EditorialRepository editorialRepository;

    public List<Editorial> getAllEditorials() {
        return editorialRepository.findAll();
    }

    public Editorial findEditorialById(Long id) {
        return editorialRepository.findById(id).orElse(null);
    }

    public void createEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    public void deleteEditorialById(long id) {
        editorialRepository.deleteById(id);
    }

    public Optional<Editorial> updateEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
        return editorialRepository.findById(editorial.getId());

    }
}
