
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Main method.
     * @param args unused arguments
     */
    public static void main(final String[] args) {
        //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        //System.out.println(urlToString("https://cs.illinois.edu/"));

        String output = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] words = output.split(" ");
        int count = 0;
        for (String str : words) {
            if (str.equalsIgnoreCase("prince")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
