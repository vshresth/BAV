package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhixiusRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;

    public PhixiusRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PhixiusRequest {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    job: ").append(toIndentedString(job)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public String getJob() {
        return job;
    }
}
