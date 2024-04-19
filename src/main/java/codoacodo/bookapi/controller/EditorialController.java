package codoacodo.bookapi.controller;

import codoacodo.bookapi.models.Editorial;
import codoacodo.bookapi.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editorials")
public class EditorialController {
    @Autowired
    EditorialService editorialService;

    @GetMapping("")
    public List<Editorial> getAllEditorials(){
        return editorialService.getAllEditorials();
    }

    @GetMapping("/{id}")
    public Optional<Editorial> findEditorialById(@PathVariable Long id){
        return Optional.ofNullable(editorialService.findEditorialById(id));
    }

    @PostMapping("/add")
    public void createEditorial(@RequestBody Editorial editorial){
         editorialService.createEditorial(editorial);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEditorialById(@PathVariable Long id){
        editorialService.deleteEditorialById(id);
    }

    @PutMapping("/update")
    public Optional<Editorial> updateEditorial(@RequestBody Editorial editorial){
        return editorialService.updateEditorial(editorial);
    }

}
