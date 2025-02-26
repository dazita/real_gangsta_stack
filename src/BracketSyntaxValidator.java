import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BracketSyntaxValidator {

    public JavaBracket validateSyntax(String filePath) throws IOException {

        MyStack<JavaBracket> brackets = new MyStack<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int lineNum = 0;
        while ((line = br.readLine()) != null) {
            lineNum++;
            for (int i = 0; i < line.length(); i++) {
                char charObject = line.charAt(i);
                if (charObject == '(' || charObject == '{' || charObject == '[') {
                    brackets.push(new JavaBracket(charObject, lineNum));
                }
                switch (charObject) {
                    case ')':
                        if (brackets.isEmpty() || (brackets.pop()).getBracket() != '(') {
                            return new JavaBracket(charObject, lineNum);
                        }
                        break;

                    case '}':
                        if (brackets.isEmpty() || (brackets.pop()).getBracket() != '{') {
                            return new JavaBracket(charObject, lineNum);
                        }
                        break;

                    case ']':
                        if (brackets.isEmpty() || (brackets.pop()).getBracket() != '[') {
                            return new JavaBracket(charObject, lineNum);
                        }
                        break;
                }
            }
        }
        br.close();
        if (!brackets.isEmpty()) {
            return brackets.peek();
        }
        return null;
    }
}
