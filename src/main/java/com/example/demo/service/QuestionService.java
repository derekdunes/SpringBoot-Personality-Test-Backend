package com.example.demo.service;

import com.example.demo.dto.Option;
import com.example.demo.dto.Question;
import com.example.demo.interfaces.iQuestionService;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService implements iQuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> find(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> paginate(Integer id) {
        return null;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);

    }

    @Override
    public void saveAll(List<Question> questions) {
        questionRepository.saveAll(questions);
    }

    @Override
    public void update(Question question, int id) {
        Question q = questionRepository.getById(id);
        q.setQuestion(question.getQuestion());

        if(question.getOptions().size() > 0){
            //find and update the options
            for (Option op1 : question.getOptions()){
                for (Option op2 : q.getOptions()){
                    if (Objects.equals(op1.getId(), op2.getId())){
                        if (!op1.getSelection().isEmpty())
                            op2.setSelection(op1.getSelection());
                        if (!op1.getType().isEmpty())
                            op2.setType(op1.getType());
                    }
                }
            }
        }

        questionRepository.save(q);

    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public void deleteById(int id) {
        questionRepository.deleteById(id);
    }
}
