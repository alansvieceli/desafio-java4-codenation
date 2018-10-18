package main.java.challenge;

import com.fasterxml.jackson.annotation.*;

public class Quote {

	private String actor;
	private String quote;

    @JsonCreator
    public Quote(@JsonProperty("actor") String actor,
                  @JsonProperty("quote") String quote) {
        this.actor = actor;
        this.quote = quote;        
    }
    
	public String getActor() {
		return this.actor;
	}

	public String getQuote() {
		return this.quote;
	}
}
