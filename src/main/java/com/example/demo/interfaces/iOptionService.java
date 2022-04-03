package com.example.demo.interfaces;

import com.example.demo.dto.Option;
import com.example.demo.dto.Question;

import java.util.List;

public interface iOptionService {

    public List<Option> findAll();
    public Option find(int id);
    public void save(Option option);
    public void saveAll(List<Option> options);
    public void update(Option option, int id);
    public void delete(Option option);
    public void deleteById(int id);

}
