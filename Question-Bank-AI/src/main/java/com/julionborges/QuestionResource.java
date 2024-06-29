package com.julionborges;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ai/question")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionResource {

    @Inject
    Assistant assistant;

    @GET
    public String test() {
        return assistant.chat("""
                Estou testando minha API, responda apenas com um OK!
                """);
    }

}
