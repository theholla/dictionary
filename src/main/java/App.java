import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("dictionary", request.session().attribute("dictionary"));
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/dictionary", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          ArrayList<Word> arrayOfWords = request.session().attribute("dictionary");
          if (arrayOfWords == null) {
            arrayOfWords = new ArrayList<Word>();
            request.session().attribute("dictionary", arrayOfWords);
          }

          //put new word into new array list
          String word = request.queryParams("name");
          Word newWord = new Word(word);
          arrayOfWords.add(newWord);

          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

  }
}
