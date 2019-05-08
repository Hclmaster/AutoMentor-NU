package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "best_answer"
})
public class Hof {

    @JsonProperty("best_answer")
    private List<BestAnswer> bestAnswer = null;

    @JsonProperty("best_answer")
    public List<BestAnswer> getBestAnswer() {
        return bestAnswer;
    }

    @JsonProperty("best_answer")
    public void setBestAnswer(List<BestAnswer> bestAnswer) {
        this.bestAnswer = bestAnswer;
    }

}
