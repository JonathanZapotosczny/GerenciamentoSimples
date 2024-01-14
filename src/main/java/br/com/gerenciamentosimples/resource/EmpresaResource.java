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

import br.com.gerenciamentosimples.dto.EmpresaDto;
import br.com.gerenciamentosimples.model.Empresa;
import br.com.gerenciamentosimples.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresas")
public class EmpresaResource {

    private final EmpresaService empresaService;

    public EmpresaResource(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro de Empresa")
    public ResponseEntity<Empresa> create(@RequestBody @Valid EmpresaDto empresaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.empresaService.create(empresaDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna a Empresa selecionada pelo ID")
    public ResponseEntity<Empresa> findById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Retorna a lista de Empresas cadastradas")
    public ResponseEntity<List<Empresa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Realiza a atualização da Empresa selecionada pelo ID")
    public ResponseEntity<Empresa> update(@PathVariable(value = "id") Integer id, 
                                        @RequestBody @Valid EmpresaDto EmpresaDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.update(EmpresaDto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui a Empresa cadastrada pelo ID")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {

        this.empresaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Empresa deletada com sucesso!");
    }
    
}
