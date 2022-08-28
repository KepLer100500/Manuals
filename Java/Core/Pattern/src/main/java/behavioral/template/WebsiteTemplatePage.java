package behavioral.template;


public abstract class WebsiteTemplatePage {
    public void showPage() {
        System.out.println("Header");
        showContent();
        System.out.println("Footer");
    }

    public abstract void showContent();
}