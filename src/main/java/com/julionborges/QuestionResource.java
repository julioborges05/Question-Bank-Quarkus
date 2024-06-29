package com.julionborges;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("questions")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionResource {

    @GET
    public List<Question> getQuestions() {
        return Question.listAll();
    }

    @GET
    @Path("/findById")
    public Question findQuestionById(@QueryParam("id") Long id) {
        return Question.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Question addQuestion(Question question) {
        question.setId(null);
        question.persist();
        return question;
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Question updateQuestion(Question question) {
        Question databaseQuestion = Question.<Question>findByIdOptional(question.getId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        databaseQuestion.setQuestion(question.getQuestion());
        databaseQuestion.setCorrectAnswer(question.getCorrectAnswer());
        databaseQuestion.setWrongAnswer1(question.getWrongAnswer1());
        databaseQuestion.setWrongAnswer2(question.getWrongAnswer2());
        databaseQuestion.setWrongAnswer3(question.getWrongAnswer3());

        databaseQuestion.persist();
        return databaseQuestion;
    }

    @DELETE
    @Transactional
    public void deleteQuestion(@QueryParam("id") Long id) {
        Question question = Question.<Question>findByIdOptional(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        question.delete();
    }

}
