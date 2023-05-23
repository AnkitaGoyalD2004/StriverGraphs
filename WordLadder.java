package StriverGraph;
import java.util.*;

class helper{
    String first;
    int second;
    helper(String _first , int _second)
    {
        this.first = _first;
        this.second= _second;
    }

}

public class WordLadder {
    public int ladderLength(String beginWord , String endWord , List<String> wordList){
       Queue<helper> q = new LinkedList<>();
       q.add(new helper(beginWord , 1));
       Set < String > st = new HashSet < String > ();
       for (String s : wordList) {
        st.add(s);
    }
        
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord) == true) return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new helper(replacedWord, steps + 1));
                    }
                }

            }
        }
        return 0;
    }
}
