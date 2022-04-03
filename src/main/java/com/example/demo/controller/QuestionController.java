package com.example.demo.controller;

import com.example.demo.dto.Answer;
import com.example.demo.dto.Option;
import com.example.demo.dto.Question;
import com.example.demo.interfaces.iOptionService;
import com.example.demo.interfaces.iQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private iOptionService optionService;

    @Autowired
    private iQuestionService questionService;

    @GetMapping(path="/get", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Question> getQuestion(@RequestParam int id) {
        System.out.println(id);
        Optional<Question> question = questionService.find(id);
        return question;
    }

    @GetMapping(path="/getAll", produces = APPLICATION_JSON_VALUE)
    public List<Question> getAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping(path="/get/paginate", produces = APPLICATION_JSON_VALUE)
    public List<Question> getAllWithPagination(@RequestParam int count) {
        return questionService.paginate(count);
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String saveQuestion(@RequestBody Question question){
        Question q1 = new Question(question.getQuestion());

        Question q2 = questionService.save(q1);

        for(Option option : question.getOptions()){
            option.setQuestion(q2);
            optionService.save(option);
        }

        System.out.println(question);
        return "Question Saved";
    }

    @PostMapping(value = "/saveAll", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String saveAllQuestions(@RequestBody List<Question> question){

        for (Question qt : question){
            Question q1 = new Question(qt.getQuestion());

            Question q2 = questionService.save(q1);

            for(Option option : qt.getOptions()){
                option.setQuestion(q2);
                optionService.save(option);
            }
        }

        return "Question Saved";
    }

    @PostMapping(value = "/answer", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String calculatePersonality(@RequestBody List<Answer> answers){
        String response = "";

        if(answers.size() == 14){
            int introCount = 0;
            int extroCount = 0;

            for (Answer ans : answers){
                if (ans.getType().equals("E")){
                    extroCount++;
                } else {
                    introCount++;
                }
            }

            System.out.println("Introvert count is " + introCount);
            System.out.println("Extrovert Count is " + extroCount);

            if (introCount > extroCount){
                return "Introvert";
            } else if (extroCount > introCount) {
                response = "Extrovert";
            } else {
                response = "Ambivalent";
            }
        } else {
            response = "Answers are incomplete";
        }

        return response;
    }

    //tested and trusted
    @PostMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String updateQuestion(@RequestParam int id, @RequestBody Question question){
        System.out.println(question.toString());
        questionService.update(question, id);
        return "Question Updated";
    }

    //haven't tried not trust worth
    @PostMapping(value = "/delete", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String deleteQuestion(@RequestBody Question question){
        System.out.println(question.toString());
        questionService.delete(question);
        return "Deleted";
    }

    //tested and trusted
    @PostMapping(value = "/deleteById", produces = APPLICATION_JSON_VALUE)
    public String deleteById(@RequestParam int id){
        questionService.deleteById(id);
        return "Deleted";
    }



}
