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

import br.com.gerenciamentosimples.dto.EntradaDto;
import br.com.gerenciamentosimples.model.Entrada;
import br.com.gerenciamentosimples.service.EntradaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/entradas")
@Tag(name = "Entradas")
public class EntradaResource {

    private final EntradaService entradaService;

    public EntradaResource(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro de entradas")
    public ResponseEntity<Entrada> create(@RequestBody @Valid EntradaDto entradaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.entradaService.create(entradaDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna a entrada selecionada pelo ID")
    public ResponseEntity<Entrada> findById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.entradaService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Retorna a lista de entradas cadastradas")
    public ResponseEntity<List<Entrada>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.entradaService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Realiza a atualização da entrada selecionada pelo ID")
    public ResponseEntity<Entrada> update(@PathVariable(value = "id") Integer id, 
                                        @RequestBody @Valid EntradaDto entradaDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.entradaService.update(entradaDto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui a entrada cadastrada pelo ID")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {

        this.entradaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("ENTRADA deletada com sucesso!");
    }
}