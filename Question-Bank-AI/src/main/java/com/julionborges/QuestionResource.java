package com.julionborges;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/ai/question")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionResource {

    @Inject
    Assistant assistant;

    @GET
    @Path("/ok")
    public String test() {
        return assistant.chat("""
                I'm testing my API, just reply with an OK!
                """);
    }

    @GET
    public Question getGeneratedQuestion(@QueryParam("topic") String topic, @QueryParam("language") String language) {
        return assistant.createMathQuestion(topic, language);
    }

}
