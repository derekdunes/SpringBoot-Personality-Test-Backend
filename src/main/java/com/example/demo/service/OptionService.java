package com.example.demo.service;

import com.example.demo.dto.Option;
import com.example.demo.interfaces.iOptionService;
import com.example.demo.repository.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements iOptionService {
    OptionRepository optionRepository;

    @Override
    public List<Option> findAll() {
        return optionRepository.findAll();
    }

    @Override
    public Option find(int id) {
        return optionRepository.getById(id);
    }

    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }

    @Override
    public void saveAll(List<Option> options) {
        optionRepository.saveAll(options);
    }

    @Override
    public void deleteById(int id){
        optionRepository.deleteById(id);
    }

    @Override
    public void update(Option option, int id) {
        Option o = optionRepository.getById(id);
        o.setSelection(option.getSelection());
        o.setType(option.getType());
        optionRepository.save(o);
    }

    @Override
    public void delete(Option option) {
        optionRepository.delete(option);
    }
}
