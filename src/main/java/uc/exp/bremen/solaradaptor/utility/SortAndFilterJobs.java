package uc.exp.bremen.solaradaptor.utility;

public class SortAndFilterJobs {

    public static String sortJobs(String sSortIndex) {
        String sortQuery;
        switch (sSortIndex) {
            case "0":
                // "exp_registered desc, score desc, exp_crawldate desc, exp_sortword_1 asc, exp_sortword_2 asc, exp_sortword_3 asc, exp_sortword_4 asc"
                sortQuery = "&sort=exp_registered+desc%2C+score+desc%2C+exp_crawldate+desc%2C+exp_sortword_1+asc%2C+exp_sortword_2+asc%2C+exp_sortword_3+asc%2C+exp_sortword_4+asc";
                break;
            case "1":
                //"score desc, exp_crawldate desc, exp_sortword_1 asc, exp_sortword_2 asc, exp_sortword_3 asc, exp_sortword_4 asc"
                sortQuery = "&sort=score+desc%2C+exp_crawldate+desc%2C+exp_sortword_1+asc%2C+exp_sortword_2+asc%2C+exp_sortword_3+asc%2C+exp_sortword_4+asc";
                break;
            case "2":
                //"score desc, exp_crawldate asc, exp_sortword_1 asc, exp_sortword_2 asc, exp_sortword_3 asc, exp_sortword_4 asc"
                sortQuery = "&sort=score+desc%2C+exp_crawldate+asc%2C+exp_sortword_1+asc%2C+exp_sortword_2+asc%2C+exp_sortword_3+asc%2C+exp_sortword_4+asc";
                break;
            case "3":
                //"exp_sortword_1 asc, exp_sortword_2 asc, exp_sortword_3 asc, exp_sortword_4 asc, score desc"
                sortQuery = "&sort=exp_sortword_1+asc%2C+exp_sortword_2+asc%2C+exp_sortword_3+asc%2C+exp_sortword_4+asc%2C+score+desc";
                break;
            case "4":
                //"exp_sortword_1 desc, exp_sortword_2 desc, exp_sortword_3 desc, exp_sortword_4 desc, score desc"
                sortQuery = "&sort=exp_sortword_1+desc%2C+exp_sortword_2+desc%2C+exp_sortword_3+desc%2C+exp_sortword_4+desc%2C+score+desc";
                break;
            default:
                sortQuery = "";
                break;
        }
        return sortQuery;
    }

    public static String filterJobs(String sFilterIndex) {
        String filterQuery;
        switch (sFilterIndex) {
            case "1":
                // "exp_registered desc, score desc, exp_crawldate desc, exp_sortword_1 asc, exp_sortword_2 asc, exp_sortword_3 asc, exp_sortword_4 asc"
                filterQuery = "+AND+exp_registered%3A1";
                break;
            default:
                filterQuery = "";
                break;
        }
        return filterQuery;
    }
}
