package piazza;

import com.fasterxml.jackson.annotation.JsonInclude;

class RequestBody {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class RequestParams {
        public String email;
        public String pass;
        public String cid;
        public String nid;
    }

    public final String method;

    public final RequestParams params;

    static class Builder{
        private final String method;
        private String email;
        private String pass;
        private String cid;
        private String nid;

        Builder(String method){
            this.method = method;
        }

        Builder email(String val) {
            this.email = val;
            return this;
        }

        Builder password(String val){
            this.pass = val;
            return this;
        }

        Builder cid(String val){
            this.cid = val;
            return this;
        }

        Builder nid(String val){
            this.nid = val;
            return this;
        }

        RequestBody build(){
            return new RequestBody(this);
        }
    }

    private RequestBody(Builder builder) {
        this.method = builder.method;
        this.params = new RequestParams();
        this.params.email = builder.email;
        this.params.pass = builder.pass;
        this.params.cid = builder.cid;
        this.params.nid = builder.nid;
    }

}