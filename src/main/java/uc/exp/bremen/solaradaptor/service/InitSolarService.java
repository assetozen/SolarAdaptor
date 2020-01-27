package uc.exp.bremen.solaradaptor.service;

import org.springframework.stereotype.Service;
import uc.exp.bremen.solaradaptor.utility.Constants;
import uc.exp.bremen.solaradaptor.utility.SortAndFilterJobs;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class InitSolarService {

    public static URL initSolarUrl(String sSearch, String sSort, String sFilter){
        String sortingOrders = SortAndFilterJobs.sortJobs(sSort);
        String filteringBy = SortAndFilterJobs.filterJobs(sFilter);
        URL url = null;
        try {
            url = new URL(Constants.PREFIX_URL  + sSearch + filteringBy + sortingOrders + Constants.WRITER_TYPE + Constants.INDENTATION);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
