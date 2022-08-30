
package QA.Java.Pojo.GetActions;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "activityBlocked",
    "avatarHash",
    "avatarUrl",
    "fullName",
    "idMemberReferrer",
    "initials",
    "nonPublic",
    "nonPublicAvailable",
    "username"
})
@Generated("jsonschema2pojo")
public class MemberCreator__1 {

    @JsonProperty("id")
    private String id;
    @JsonProperty("activityBlocked")
    private Boolean activityBlocked;
    @JsonProperty("avatarHash")
    private String avatarHash;
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("idMemberReferrer")
    private Object idMemberReferrer;
    @JsonProperty("initials")
    private String initials;
    @JsonProperty("nonPublic")
    private NonPublic nonPublic;
    @JsonProperty("nonPublicAvailable")
    private Boolean nonPublicAvailable;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("activityBlocked")
    public Boolean getActivityBlocked() {
        return activityBlocked;
    }

    @JsonProperty("activityBlocked")
    public void setActivityBlocked(Boolean activityBlocked) {
        this.activityBlocked = activityBlocked;
    }

    @JsonProperty("avatarHash")
    public String getAvatarHash() {
        return avatarHash;
    }

    @JsonProperty("avatarHash")
    public void setAvatarHash(String avatarHash) {
        this.avatarHash = avatarHash;
    }

    @JsonProperty("avatarUrl")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatarUrl")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("idMemberReferrer")
    public Object getIdMemberReferrer() {
        return idMemberReferrer;
    }

    @JsonProperty("idMemberReferrer")
    public void setIdMemberReferrer(Object idMemberReferrer) {
        this.idMemberReferrer = idMemberReferrer;
    }

    @JsonProperty("initials")
    public String getInitials() {
        return initials;
    }

    @JsonProperty("initials")
    public void setInitials(String initials) {
        this.initials = initials;
    }

    @JsonProperty("nonPublic")
    public NonPublic getNonPublic() {
        return nonPublic;
    }

    @JsonProperty("nonPublic")
    public void setNonPublic(NonPublic nonPublic) {
        this.nonPublic = nonPublic;
    }

    @JsonProperty("nonPublicAvailable")
    public Boolean getNonPublicAvailable() {
        return nonPublicAvailable;
    }

    @JsonProperty("nonPublicAvailable")
    public void setNonPublicAvailable(Boolean nonPublicAvailable) {
        this.nonPublicAvailable = nonPublicAvailable;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
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
