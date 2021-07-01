package _19_string_regex.practice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Th3CrawlSongName {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            //--> các phương thức của socket (lập trình mạng)
            //url.openStream()<---openConnection().getInputStream()<--- url.handler.openConnection()
            //openConnection(): return 1 link dẫn đến URL
            //getInputStream(): return an "input stream" that reads from this open connection.
            // -->Trả về input stream của Socket.
            Scanner scanner = new Scanner(inputStreamReader); //đọc file từ máy scan - character stream
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    public static void crawlSong(URL ulr) {
//
//    }
}
