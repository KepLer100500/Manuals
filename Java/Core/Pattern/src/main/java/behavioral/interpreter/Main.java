package behavioral.interpreter;

/**
 * Интерпретатор (Interpreter) определяет представление грамматики для заданного языка
 * и интерпретатор предложений этого языка.
 * Как правило, данный шаблон проектирования применяется для часто повторяющихся операций.
 */

public class Main {
    public static void main(String[] args) {
        Expression isJava = getJavaExpression();
        Expression isJavaEE = getJavaEEExpression();

        System.out.println("Developer knows java core: " + isJava.interpret("Java Core"));
        System.out.println("Developer knows java EE: " + isJavaEE.interpret("Java Spring"));
    }

    public static Expression getJavaExpression() {
        Expression java = new TerminalExpression("Java");
        Expression javaCore = new TerminalExpression("Java Core");

        return new OrExpression(java, javaCore);
    }

    public static Expression getJavaEEExpression() {
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");

        return new AndExpression(java, spring);
    }
}