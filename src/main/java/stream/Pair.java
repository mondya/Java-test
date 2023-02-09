package stream;

/**
 * @author xhh
 * @date 2022/1/22 11:53
 */
public class Pair<String,BigDecimal> {
    String version;
    BigDecimal versionNumber;

    public Pair() {
    }
    
    
    public Pair(String version, BigDecimal versionNumber) {
        this.version = version;
        this.versionNumber = versionNumber;
    }

    public  String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(BigDecimal versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public java.lang.String toString() {
        return "Pair{" +
                "version=" + version +
                ", versionNumber=" + versionNumber +
                '}';
    }
}
