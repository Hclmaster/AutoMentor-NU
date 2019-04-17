package com.nu.automentor.myTest;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.*;

public class TestPiazzaApi {
    public static void main(String args[]) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        Process proc;
        try {
            String exe = "python";
            String command = "/Users/cathylin/Desktop/Research/piazza-api/test_api/intializePiazza.py";
            String email = "chenghonglin2020@u.northwestern.edu";
            String password = "DRAGON574cathy";
            String[] cmdArr = new String[] {exe, command, email, password};
            proc = Runtime.getRuntime().exec(cmdArr);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                System.out.println("Type => " + line.getClass());
                //JSONObject jsonObj = new JSONObject(line);
                JSONObject jsonObj = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
                System.out.println(jsonObj);

            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
