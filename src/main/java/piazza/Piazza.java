package piazza;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;


public class Piazza {

    private static final String LOGIC_URL = "https://piazza.com/logic/api";

    private static final String MAIN_URL =  "https://piazza.com/main/api";

    private CookieManager cookieManager;

    public Piazza(){
        cookieManager = new CookieManager();
    }

    public static void main(String[] args) {
        new Piazza().testIt();
    }

    private class RequestBody {
        public String method;
        public RequestParams params;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class RequestParams {
        public String email;
        public String pass;
        public String cid;
        public String nid;
    }

    private void testIt(){

        userLogin();

        contentGet("432", "jbzfbbon3nt32i");
    }

    public void userLogin(){
        BufferedReader reader =
                new BufferedReader( new InputStreamReader(System.in));
        try {
            System.out.print("email: ");
            String email = reader.readLine();

            System.out.print("password: ");
            String password = reader.readLine();

            userLogin(email, password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userLogin(String email, String password){
        try {
            URL url = new URL(LOGIC_URL);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            ObjectWriter ow = new ObjectMapper().writer();
            RequestBody body = new RequestBody();
            body.method = "user.login";
            body.params = new RequestParams();
            body.params.email = email;
            body.params.pass = password;

            String json = ow.writeValueAsString(body);

            byte[] outputInBytes = json.getBytes("UTF-8");
            OutputStream os = connection.getOutputStream();
            os.write( outputInBytes );
            os.close();

            connection.getHeaderFields()
                    .get("Set-Cookie")
                    .stream()
                    .map(HttpCookie::parse)
                    .flatMap(x -> x.stream())
                    .forEach(x -> cookieManager.getCookieStore().add(null, x));

            printContent(connection);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void contentGet(String cid, String nid){
        RequestParams params = new RequestParams();
        params.cid = cid;
        params.nid = nid;
        request("content.get", params);
    }

    private String sessionId(){
        String id = cookieManager.getCookieStore()
                .getCookies()
                .stream()
                .filter(x -> x.getName().equals("session_id"))
                .findFirst()
                .get()
                .getValue();

        return id;
    }

    private String cookieHeader(){
        List<String> cookieStrings = cookieManager.getCookieStore()
                .getCookies()
                .stream()
                .map(x->x.toString())
                .collect(Collectors.toList());

        String header = String.join("; ",  cookieStrings);

        return header;
    }

    private void request(String method, RequestParams params){
        try {
            URL url = new URL(LOGIC_URL);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("CSRF-Token", sessionId());
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Cookie", cookieHeader());

            connection.setDoOutput(true);
            connection.setDoInput(true);

            ObjectWriter ow = new ObjectMapper().writer();
            RequestBody body = new RequestBody();
            body.method = method;
            body.params = params;
            String json = ow.writeValueAsString(body);

            byte[] outputInBytes = json.getBytes("UTF-8");
            OutputStream os = connection.getOutputStream();
            os.write( outputInBytes );
            os.close();

            printContent(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void printContent(HttpsURLConnection con){
        if(con!=null){

            try {

                System.out.println("****** Content of the URL ********");
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(con.getInputStream()));

                String input;

                while ((input = br.readLine()) != null){
                    System.out.println(input);
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}

