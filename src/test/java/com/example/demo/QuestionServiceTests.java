package com.example.demo;

import com.example.demo.dto.Option;
import com.example.demo.dto.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
public class QuestionServiceTests {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setUp() throws Exception{
    }

    @Test
    void testFindAll(){
        List<Question> questions = new ArrayList<Question>();
        Question question1 = new Question();
        question1.setQuestion("Odogwu how far");
        question1.setId(1);
        Set<Option>
        when(questionRepository.findAll()).thenReturn();

    }

    @Test
    void testSave(){

        when(questionRepository.save()).thenReturn();

    }

    @Test
    void testSaveAll(){

        when(questionRepository.saveAll()).thenReturn();

    }

    @Test
    void testGetById(){

        when(questionRepository.getById()).thenReturn();

    }

    @Test
    void testFindById(){

        when(questionRepository.findById()).thenReturn();

    }

    @Test
    void testDeleteById(){

        when(questionRepository.deleteById()).thenReturn();

    }

    @Test
    void testSaveAll(){
        when(questionRepository.delete()).thenReturn();

    }


}
