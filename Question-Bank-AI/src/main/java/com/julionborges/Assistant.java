package com.julionborges;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface Assistant {

    String chat(String message);

}
