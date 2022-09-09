
package QA.Java.Pojo.GetActions;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "card",
    "old",
    "board",
    "listBefore",
    "listAfter"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("card")
    private Card card;
    @JsonProperty("old")
    private Old old;
    @JsonProperty("board")
    private Board board;
    @JsonProperty("listBefore")
    private ListBefore listBefore;
    @JsonProperty("listAfter")
    private ListAfter listAfter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("card")
    public Card getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(Card card) {
        this.card = card;
    }

    @JsonProperty("old")
    public Old getOld() {
        return old;
    }

    @JsonProperty("old")
    public void setOld(Old old) {
        this.old = old;
    }

    @JsonProperty("board")
    public Board getBoard() {
        return board;
    }

    @JsonProperty("board")
    public void setBoard(Board board) {
        this.board = board;
    }

    @JsonProperty("listBefore")
    public ListBefore getListBefore() {
        return listBefore;
    }

    @JsonProperty("listBefore")
    public void setListBefore(ListBefore listBefore) {
        this.listBefore = listBefore;
    }

    @JsonProperty("listAfter")
    public ListAfter getListAfter() {
        return listAfter;
    }

    @JsonProperty("listAfter")
    public void setListAfter(ListAfter listAfter) {
        this.listAfter = listAfter;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
