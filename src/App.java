public class App {
    public static void main(String[] args) throws Exception {
        BracketSyntaxValidator validator = new BracketSyntaxValidator();
        JavaBracket wrongBracket = validator.validateSyntax("src\\UnexpectedClosing.java");
        System.out.println("Error: " + wrongBracket.getBracket() +  " en la línea " + wrongBracket.getLine());
        wrongBracket = validator.validateSyntax("src\\MissingBracket.java");
        System.out.println("Error: " + wrongBracket.getBracket() +  " en la línea " + wrongBracket.getLine());
    }
}
