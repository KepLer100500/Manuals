package behavioral.templateMethod;

/**
 * Шаблонный метод - определяет основу класса и позволяет
 * подклассам переопределять некоторые его части не изменяя его структуру в целом.
 */

public class Main {
    public static void main(String[] args) {
        WebsiteTemplatePage welcomePage = new WelcomePage();
        WebsiteTemplatePage newsPage = new NewsPage();
        
        welcomePage.showPage();
        System.out.println("===========");
        newsPage.showPage();
    }
}
