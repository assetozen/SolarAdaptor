package uc.exp.bremen.solaradaptor.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Controller
public class JobsController extends BaseController {

    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJobsFromSolar(@RequestParam("sSearch") String sSearch){
        String output = "";

        try {
            URL url = new URL("http://172.16.200.58:10090/solr/collection1/select?q=exp_jobtitle%3A" + sSearch + "&wt=json&indent=true");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String readline;
            while ((readline = br.readLine()) != null) {
                output = output.concat(readline);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
