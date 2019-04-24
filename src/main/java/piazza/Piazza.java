package piazza;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Piazza {

    private static final String LOGIC_URL = "https://piazza.com/logic/api";

    private static final String MAIN_URL =  "https://piazza.com/main/api";

    private CookieManager cookieManager;

    public Piazza(){
        cookieManager = new CookieManager();
    }

    public static void main(String[] args) throws IOException {
        new Piazza().testIt();
    }

    private void testIt() throws IOException {

        userLogin();

        ContentGetResponse r = contentGet("432", "jbzfbbon3nt32i");
        System.out.println("post:");
        System.out.println(r.getResult().getHistory().get(0).getContent());
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
            UserLoginRequest body = new UserLoginRequest("user.login", email, password);

            HttpsURLConnection connection = requestBase();

            writeBody(connection, body);

            storeCookies(connection);

            printContent(connection);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private HttpsURLConnection requestBase() throws IOException {
        URL url = new URL(LOGIC_URL);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        return connection;
    }

    private void writeBody(HttpsURLConnection connection, Object body) throws IOException {
        byte[] outputInBytes = new ObjectMapper().writer().writeValueAsBytes(body);

        OutputStream os = connection.getOutputStream();
        os.write( outputInBytes );
        os.close();
    }

    private void storeCookies(HttpsURLConnection connection){
        connection.getHeaderFields()
                .get("Set-Cookie")
                .stream()
                .map(HttpCookie::parse)
                .flatMap(Collection::stream)
                .forEach(x -> cookieManager.getCookieStore().add(null, x));
    }

    public ContentGetResponse contentGet(String cid, String nid) throws IOException {
        ContentGetRequest body = new ContentGetRequest("content.get", cid, nid);

        HttpsURLConnection connection = request(body);
        return parseResponse(connection);
    }

    private String sessionId(){

        return cookieManager.getCookieStore()
                .getCookies()
                .stream()
                .filter(x -> x.getName().equals("session_id"))
                .findFirst()
                .get()
                .getValue();
    }

    private String cookieHeader(){
        List<String> cookieStrings = cookieManager.getCookieStore()
                .getCookies()
                .stream()
                .map(HttpCookie::toString)
                .collect(Collectors.toList());

        return String.join("; ",  cookieStrings);
    }

    private HttpsURLConnection request(Object body) throws IOException {
        HttpsURLConnection connection = requestBase();

        connection.setRequestProperty("Cookie", cookieHeader());
        connection.setRequestProperty("CSRF-Token", sessionId());

        writeBody(connection, body);

        return connection;
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

    private ContentGetResponse parseResponse(HttpsURLConnection connection) throws IOException {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        System.out.println(sb);

        ObjectMapper om = new ObjectMapper();
        return om.readValue(sb.toString(), ContentGetResponse.class);
    }

}

