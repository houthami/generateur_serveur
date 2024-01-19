package app.megashop.config;

public class ForeignKey {
    private String forienName;
    private String forienClass;

    public ForeignKey(String forienName, String forienClass) {
        this.forienName = forienName;
        this.forienClass = forienClass;
    }

    @Override
    public String toString() {
        return "ForeignKey{" +
                "forienName='" + forienName + '\'' +
                ", forienClass='" + forienClass + '\'' +
                '}';
    }
}
