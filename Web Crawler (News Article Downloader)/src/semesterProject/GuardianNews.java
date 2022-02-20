package semesterProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
/*
The function of this class is to take a file of urls,
read the file, take each url from the file, and create a
new file that contains the contents of the article.
 */
public class GuardianNews {

    private String fileName;
    private String tempTitle;
    private String tempName;
    private String authorName;
    private String date;
    private String tempBody;
    private FileWriter w;

    public GuardianNews(){}

    public GuardianNews(String file){
        fileName = file;
    }

    public void generateFiles() throws IOException {
       String[] urls = Files.readAllLines(new File(fileName)
                .toPath()).toArray(new String[0]);
        for (String url : urls){
            Document tempDocument = Jsoup.connect(url).get();
            Elements title = tempDocument.select("h1");
            tempTitle = title.toString();
            try {
                if (tempTitle.length() >= 5) {
                    tempTitle = tempTitle.substring(tempTitle.indexOf(">"));
                    tempTitle = tempTitle.substring(2, tempTitle.indexOf("<") - 1);
                }
            }catch(StringIndexOutOfBoundsException s){
                s.printStackTrace();
            }
            if (tempTitle.charAt(tempTitle.length()-1)=='?'){
                tempTitle = tempTitle.substring(0,tempTitle.length()-1);
            }
            Elements author = tempDocument.select("span");
            authorName = null;
            for (Element span : author) {
                tempName = span.toString();
                if (tempName.contains("<span itemprop=\"name\">"))
                    authorName = tempName.substring(tempName.indexOf("name"));
            }
            try{
                authorName = authorName.substring(authorName.indexOf(">")+1);
                authorName = authorName.substring(0, authorName.indexOf("<"));
            }catch(NullPointerException e){
                e.getSuppressed();
            }
            Elements body = tempDocument.select("p");
            tempBody = null;
            date = null;
            for (Element s : body){
                tempBody = s.toString();
                tempBody = tempBody.substring(3,tempBody.indexOf("</p>"));
                if (tempBody.contains("datePublished")){
                    tempBody = tempBody.substring(tempBody.indexOf("datetime"));
                    tempBody = tempBody.substring(10,tempBody.indexOf("T"));
                    date = tempBody;
                }
            }
            File file = new File(tempTitle+".dat");
            w = null;
            try{
                w = new FileWriter(file);
                w.write("from url:\n"+url);
                w.write("\ntitle:\n"+tempTitle);
                w.write("\nauthor:\n"+authorName);
                w.write("\ndate:\n"+date+"\nbody:\n");
                for (Element s : body){
                    tempBody = s.toString();
                    tempBody = tempBody.substring(3,tempBody.indexOf("</p>"));
                    if(tempBody.contains("datePublished")==false)
                        w.write(tempBody+"\n");
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
}
