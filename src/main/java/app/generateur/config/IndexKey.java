package app.generateur.config;

public class IndexKey {
    private String indexName;
    private Boolean unique;

    public IndexKey(String indexName, Boolean unique) {
        this.indexName = indexName;
        this.unique = unique;
    }

    public String getIndexName() {
        return indexName;
    }

    public Boolean getUnique() {
        return unique;
    }

    @Override
    public String toString() {
        return "ForeignKey{" +
                "forienName='" + indexName + '\'' +
                ", forienClass='" + unique + '\'' +
                '}';
    }
}
