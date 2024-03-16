package isp.lab7.safehome;

import java.util.Objects;

public class AccessKey {

    private String key;

    public AccessKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessKey accessKey = (AccessKey) o;
        return Objects.equals(key, accessKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
