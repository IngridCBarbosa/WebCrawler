package threadwebcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ingrid
 */
public class WebCrawler {

    private String s;

    public void getPageLinks(String url) {
        Buffer urlBuffer = Buffer.getInstance();
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<String> Urls = new ArrayList<String>();
            Elements linksPage = doc.getElementsByTag("img");

            for (Element img : linksPage) {
                Urls.add(img.attr("src"));
                urlBuffer.increment();
            }
            urlBuffer.setURL(Urls);
        } catch (IOException e) {
        }
    }

    public void download() {
        int i = 0;
        String t;
        try {
            for (String link : Buffer.getURL()) {
                if (!link.startsWith("http")) {
                    if (link.startsWith("//")) {
                        String s1 = "http:";
                        String s2 = link;
                        link = s1 + s2;
                        downloadImage(link);
                    } else {
                        System.out.println("Erro em : " + link);
                    }
                } else {
                    downloadImage(link);
                }
            }
        } catch (Exception e) {
            System.err.println("Deu merda!" + e);
        }

    }

    private void downloadImage(String link) throws MalformedURLException, IOException {
        InputStream in = new URL(link).openStream();
        System.out.println("Baixando: " + link);
        Files.copy(in, Paths.get("C:\\Users\\Ingrid\\Pictures\\Pictures" + Math.random() + ".png"));
        in.close();
    }    
}
