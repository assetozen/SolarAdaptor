package uc.exp.bremen.solaradaptor.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uc.exp.bremen.solaradaptor.utility.Constants;
import uc.exp.bremen.solaradaptor.utility.SortAndFilterJobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class JobsController extends BaseController {

    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJobsFromSolar(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("sSort") String sSort,
                                   @RequestParam("sFilter") String sFilter) {
        String output = "";
        //changes made in firstBranch
        try {
            String sortingOrders = SortAndFilterJobs.sortJobs(sSort);
            String filteringBy = SortAndFilterJobs.filterJobs(sFilter);
            URL url = new URL(Constants.PREFIX_URL  + sSearch + filteringBy + sortingOrders + Constants.WRITER_TYPE + Constants.INDENTATION);
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
