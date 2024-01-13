package br.com.gerenciamentosimples.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.gerenciamentosimples.dto.CategoriaDto;
import br.com.gerenciamentosimples.exception.NotFoundException;
import br.com.gerenciamentosimples.model.Categoria;
import br.com.gerenciamentosimples.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    private ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    } 

    public Categoria create(CategoriaDto categoriaDto){

        Categoria categoria = this.modelMapper.map(categoriaDto, Categoria.class);
        return this.categoriaRepository.save(categoria);
    }

    public Categoria findById(Integer id){

        Optional<Categoria> optCategoria = this.categoriaRepository.findById(id);
        return optCategoria.orElseThrow(() -> new NotFoundException("CATEGORIA não encontrada na base de dados!"));
    }

    public List<Categoria> findAll(){
        return this.categoriaRepository.findAll();
    }

    public Categoria update(CategoriaDto categoriaDto, Integer id){

        Optional<Categoria> optCategoria = this.categoriaRepository.findById(id);

        if(!optCategoria.isPresent()){
            throw new NotFoundException("CATEGORIA não encontrada na base de dados!");
        }
        
        Categoria categoria = this.modelMapper.map(categoriaDto, Categoria.class);
        categoria.setId(id);
        return this.categoriaRepository.save(categoria);
    }

    public void delete(Integer id){

        Optional<Categoria> optCategoria = this.categoriaRepository.findById(id);

        if(!optCategoria.isPresent()){
            throw new NotFoundException("CATEGORIA não encontrada na base de dados!");
        }
        
        this.categoriaRepository.delete(optCategoria.get());
    }
}