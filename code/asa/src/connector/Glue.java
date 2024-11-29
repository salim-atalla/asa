package connector;

/**
 * Represents a Glue in the system.
 */
public class Glue {
    private String glueId; // Unique identifier for the glue.

    public Glue(String glueId) {
        this.glueId = glueId;
    }

    public String getGlueId() {
        return glueId;
    }

    public void setGlueId(String glueId) {
        this.glueId = glueId;
    }
}
