package Problem1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int answer = 1;
        String previous = "";
        String current = "";
        for (int i = 0; i < n; i++) {
            if(i == 0){
                current = input.nextLine();
            }
            else{
                previous = current;
                current = input.nextLine();
                String result = compare(previous , current);
                if(result.equals("more")){
                    continue;
                }
                else if(result.equals("less")){
                    answer++;
                    continue;
                }
                else if(result.equals("equals")){
                    answer++;
                    continue;
                }
            }
        }
        System.out.println(answer);
    }

    public static String compare(String s , String p){
        String[] sNew = s.split(":");
        String[] pNew = p.split(":");
        if(Integer.parseInt(pNew[0]) > Integer.parseInt(sNew[0])){
            return "more";
        }
        else{
            if(Integer.parseInt(pNew[0]) < Integer.parseInt(sNew[0])){
                return "less";
            }

            if(Integer.parseInt(pNew[1]) > Integer.parseInt(sNew[1])){
                return "more";
            }
            else{
                if(Integer.parseInt(pNew[1]) < Integer.parseInt(sNew[1])){
                    return "less";
                }

                if(Integer.parseInt(pNew[2]) > Integer.parseInt(sNew[2])){
                    return "more";
                }
                else {
                    if(Integer.parseInt(pNew[2]) < Integer.parseInt(sNew[2])){
                        return "less";
                    }
                    return "equals";
                }
            }
        }
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
