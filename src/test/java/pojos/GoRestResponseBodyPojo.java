package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponseBodyPojo {

    //1)Create private variables for every key
    private Object meta;
    private GoRestDataPojo data;

    //2)Create constructor with all parameters, and without any parameter
    public GoRestResponseBodyPojo(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }
    public GoRestResponseBodyPojo() {
    }

    //3)Create getters and setters
    public Object getMeta() {
        return meta;
    }
    public void setMeta(Object meta) {
        this.meta = meta;
    }
    public GoRestDataPojo getData() {
        return data;
    }
    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    //4)Create toString() method

    @Override
    public String toString() {
        return "GoRestResponseBodyPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
