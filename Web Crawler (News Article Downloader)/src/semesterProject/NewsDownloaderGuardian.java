package semesterProject;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
This class connects to the rss feed on
theguardian.com. From there, it creates a file
of urls, which is then used by the GuardianNews class.
 */
public class NewsDownloaderGuardian {
    private String temp = null;
    private Document document = null;
    private FileWriter w = null;

    public NewsDownloaderGuardian() {
    }

    public void download() {
        try {
            document = Jsoup.connect("https://www.theguardian.com/us-news/rss").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements url = document.select("guid");

        File file = new File("GuardianLinks.dat");
        w = null;
        try{
            w = new FileWriter(file);
            for (Element link : url) {
                temp = link.toString();
                temp = temp.substring(8, temp.length() - 8);
                if (temp.contains("/video/") == false && temp.contains("/live/") == false
                        && temp.contains("/info/") == false && temp.contains("/sport/") == false)
                    w.write(temp+"\r\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                w.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}



