package br.com.gerenciamentosimples.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.gerenciamentosimples.dto.EntradaDto;
import br.com.gerenciamentosimples.model.Entrada;
import br.com.gerenciamentosimples.repository.EntradaRepository;
import br.com.gerenciamentosimples.exception.NotFoundException;

@Service
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final ModelMapper modelMapper;

    public EntradaService(EntradaRepository entradaRepository, ModelMapper modelMapper) {
        this.entradaRepository = entradaRepository;
        this.modelMapper = modelMapper;
    }

    public Entrada create(EntradaDto entradaDto) {

        Entrada entrada = this.modelMapper.map(entradaDto, Entrada.class);
        return this.entradaRepository.save(entrada);
    }

    public Entrada findById(Integer id) {
        
        Optional<Entrada> optEntrada = this.entradaRepository.findById(id);
        return optEntrada.orElseThrow(() -> new NotFoundException("ENTRADA não encontrada na base de dados!"));
    }

    public List<Entrada> findAll() {
        return this.entradaRepository.findAll();
    }

    public Entrada update(EntradaDto entradaDto, Integer id) {

        Optional<Entrada> optEntrada = this.entradaRepository.findById(id);

        if (optEntrada.isEmpty()) {
            throw new NotFoundException("ENTRADA não encontrada na base de dados!");
        }

        Entrada entradaAtualizada = this.modelMapper.map(entradaDto, Entrada.class);
        entradaAtualizada.setId(optEntrada.get().getId());

        return this.entradaRepository.save(entradaAtualizada);
    }

    public void delete(Integer id) {
        
        Optional<Entrada> optEntrada = this.entradaRepository.findById(id);

        if(optEntrada.isEmpty()) {
            throw new NotFoundException("ENTRADA não encontrada na base de dados!");
        }

        this.entradaRepository.deleteById(id);
    }
}