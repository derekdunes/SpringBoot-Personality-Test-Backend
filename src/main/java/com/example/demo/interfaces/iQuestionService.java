package com.example.demo.interfaces;

import com.example.demo.dto.Question;

import java.util.List;
import java.util.Optional;

public interface iQuestionService {
    public List<Question> findAll();
    public Optional<Question> find(Integer id);
    public List<Question> paginate(Integer id);
    public Question save(Question question);
    public void saveAll(List<Question> questions);
    public void update(Question question, int id);
    public void delete(Question question);
    public void deleteById(int id);
}
