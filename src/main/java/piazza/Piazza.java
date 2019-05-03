package piazza;

import com.fasterxml.jackson.databind.ObjectMapper;
import piazza.models.ContentGetRequest;
import piazza.models.ContentGetResponse;
import piazza.models.UserLoginRequest;
import piazza.models.UserLoginResponse;

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

    public boolean isAuthenticated() {
        List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();

        return !cookies.isEmpty() && cookies.stream().noneMatch(HttpCookie::hasExpired);
    }

    public UserLoginResponse userLogin() throws IOException {
        BufferedReader reader =
                new BufferedReader( new InputStreamReader(System.in));

        System.out.print("email: ");
        String email = reader.readLine();

        System.out.print("password: ");
        String password = reader.readLine();

        return userLogin(email, password);
    }

    public UserLoginResponse userLogin(String email, String password) throws IOException {
        UserLoginRequest body = new UserLoginRequest("user.login", email, password);

        HttpsURLConnection connection = requestBase();

        writeBody(connection, body);

        String data = getResponse(connection);

        storeCookies(connection);

        return new ObjectMapper().readValue(data, UserLoginResponse.class);
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
        String data = getResponse(connection);

        return new ObjectMapper().readValue(data, ContentGetResponse.class);
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

    private String getResponse(HttpsURLConnection connection) throws IOException {
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

        return sb.toString();
    }

}

