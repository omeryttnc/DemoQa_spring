package QA.Api_RestApi.POJOS;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userName",
        "password"
})
@Generated("jsonschema2pojo")
public class US01AutorisedPojo {

    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public US01AutorisedPojo(){

    }
    public US01AutorisedPojo(String ali, String veli){
        this.userName=ali;
        this.password=veli;

    }

    @Override
    public String toString() {
        return "US01PostAutorizedPojo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}


