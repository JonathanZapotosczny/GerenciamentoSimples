package br.com.gerenciamentosimples.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.gerenciamentosimples.dto.EmpresaDto;
import br.com.gerenciamentosimples.exception.DataIntegrityViolationException;
import br.com.gerenciamentosimples.exception.NotFoundException;
import br.com.gerenciamentosimples.model.Empresa;
import br.com.gerenciamentosimples.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ModelMapper modelMapper;

    public EmpresaService(EmpresaRepository empresaRepository, ModelMapper modelMapper) {
        this.empresaRepository = empresaRepository;
        this.modelMapper = modelMapper;
    }

    public Empresa create(EmpresaDto empresaDto){

        Optional<Empresa> optEmpresa = this.empresaRepository.findByCnpj(empresaDto.getCnpj());

        if(optEmpresa.isPresent()){
            throw new DataIntegrityViolationException("CNPJ já cadastrado na base de dados!");
        }

        Empresa empresa = this.modelMapper.map(empresaDto, Empresa.class);
        return this.empresaRepository.save(empresa);
    }

    public Empresa findById(Integer id){
        
        Optional<Empresa> optEmpresa = this.empresaRepository.findById(id);
        return optEmpresa.orElseThrow(() -> new NotFoundException("EMPRESA não encontrada na base de dados!"));
    }

    public List<Empresa> findAll(){
        return this.empresaRepository.findAll();
    }

    public Empresa update(EmpresaDto empresaDto, Integer id){

        Optional<Empresa> optEmpresa = this.empresaRepository.findById(id);
        Optional<Empresa> optEmpresaCnpj = this.empresaRepository.findByCnpj(empresaDto.getCnpj());

        
        if(!optEmpresa.isPresent()){
            throw new NotFoundException("EMPRESA não encontrada na base de dados!");
        }
           
        if (optEmpresaCnpj.isPresent() && !empresaDto.getCnpj().equals(optEmpresa.get().getCnpj()) ) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado na base de dados!");
        }

        Empresa empresa = this.modelMapper.map(empresaDto, Empresa.class);
        empresa.setId(id);
        return this.empresaRepository.save(empresa);
    }

    public void delete(Integer id){

        Optional<Empresa> optEmpresa = this.empresaRepository.findById(id);
        
        if(!optEmpresa.isPresent()){
            throw new NotFoundException("EMPRESA não encontrada na base de dados!");
        }

        this.empresaRepository.delete(optEmpresa.get());
    }
}
