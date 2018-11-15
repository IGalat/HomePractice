package tutorialsPoint._10_autowire.byConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans10byConstructor.xml");
      TextEditor te = (TextEditor) context.getBean("textEditor");
      te.spellCheck();
   }
}