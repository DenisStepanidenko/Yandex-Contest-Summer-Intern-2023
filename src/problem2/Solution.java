package problem2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            String s = input.nextLine();
            String p = input.nextLine();
            boolean flag = check(s , p);
            if(flag){
                flag = check(p , s);
                if(flag){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("NO");
            }
        }
    }

    public static boolean check(String s, String p) {
        Map<Character, Character> current = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentCharacterS = s.charAt(i);
            Character currentCharacterP = p.charAt(i);
            if(current.containsKey(currentCharacterS)){
                if(current.get(currentCharacterS) == currentCharacterP){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                current.put(currentCharacterS , currentCharacterP);
            }
        }
        return true;
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
