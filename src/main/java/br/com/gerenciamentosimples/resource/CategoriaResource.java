package br.com.gerenciamentosimples.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentosimples.dto.CategoriaDto;
import br.com.gerenciamentosimples.model.Categoria;
import br.com.gerenciamentosimples.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(name = "/categorias")
@Tag(name = "Categorias")
public class CategoriaResource {
    
    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro de categorias")
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDto categoriaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.create(categoriaDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna a Categoria selecionada pelo ID")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Retorna a lista de Categorias cadastradas")
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Realiza a atualização da Categoria selecionada pelo ID")
    public ResponseEntity<Categoria> update(@PathVariable(value = "id") Integer id, 
                                        @RequestBody @Valid CategoriaDto categoriaDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.update(categoriaDto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui a Categoria cadastrada pelo ID")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {

        this.categoriaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso!");
    }

}
