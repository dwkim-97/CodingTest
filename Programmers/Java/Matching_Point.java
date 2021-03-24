import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matching_Point {
    public static void main(String[] args){
        Solution sol = new Solution();
        //System.out.println(sol.solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com/howh.index\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
        //System.out.println(sol.solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
        System.out.println(sol.solution("hi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.hi.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07chihihiihihi1hi32hi@hi.hihi'hi'hi3on&&\n\n</body>\n</html>"}));
    }
    
    static class Solution {
        HashMap<String, Link> Links;
        public int solution(String word, String[] pages) {
            Links = new HashMap<>();

            Pattern home_url_pattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
            Pattern url_pattern = Pattern.compile("<a href=\"https://(\\S*)\"");
            Pattern word_pattern = Pattern.compile("\\b(?i)"+word+"\\b");
            Matcher url_matcher, word_matcher, home_url_matcher;

            ArrayList<String> ext_urls;
            Link new_Link;
            String body;
            String home_url = "";

            for(int i = 0; i < pages.length; i++){
                url_matcher = url_pattern.matcher(pages[i]);
                home_url_matcher = home_url_pattern.matcher(pages[i]);

                if(home_url_matcher.find()){
                    home_url = home_url_matcher.group().split("=")[2].replaceAll("\"", "");
                }

                new_Link = new Link(i, home_url);

                ext_urls = new ArrayList<>();

                while(url_matcher.find()) {
                    ext_urls.add(url_matcher.group().split("\"")[1]);
                }
                new_Link.setExtUrls(ext_urls);


                body = pages[i].split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " ");
                word_matcher = word_pattern.matcher(body);
                int word_cnt = 0;
                while(word_matcher.find())
                    word_cnt++;

                new_Link.point = word_cnt;
                new_Link.setLinkPoint();

                Links.put(new_Link.url, new_Link);
            }

            for(Link link: Links.values()){
                for(String ext_url : link.ext_urls){
                    if(Links.containsKey(ext_url)){
                        Links.get(ext_url).point += link.link_point;
                    }
                }
            }

            double max_point = 0;
            int answer = 0;
            for(Link link: Links.values()){
                if(link.point == max_point){
                    if(link.index < answer)
                        answer = link.index;
                }
                else if(link.point > max_point) {
                    answer = link.index;
                    max_point = link.point;
                }
            }

            return answer;
        }

        class Link{
            String url;
            String[] ext_urls;
            double point, link_point;
            int index;

            public Link(int i, String url){
                this.index = i;
                this.url = url;
            }

            public void setExtUrls(ArrayList<String> urls){
                this.ext_urls = new String[urls.size()];
                for(int i = 0; i < urls.size(); i++){
                    ext_urls[i] = urls.get(i);
                }
            }

            public void setLinkPoint(){
                this.link_point = this.point / ext_urls.length;
            }
        }
    }
}
