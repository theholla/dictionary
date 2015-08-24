import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //makes the home page from a template
    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // uses the new method Definition.all() to put the instances of arraylist in to the model
    get("/definitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("definitions", Definition.all());
      model.put("template", "templates/definitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/def-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/definitions", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word thisWord = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String description = request.queryParams("description");
      Definition newDefinition = new Definition(description);
      thisWord.addDefinition(newDefinition);
      model.put("word", thisWord);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitions/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Definition myDef = Definition.find(Integer.parseInt(request.params(":id")));
      model.put("description", myDef); // am I sure I want description here??
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Word newWord = new Word(name);
      model.put("word", newWord);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word thisWord = Word.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> theseDefinitions = thisWord.getDefinitions();
      model.put("word", thisWord);
      model.put("definitions", theseDefinitions);
      model.put("template", "templates/def-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    /*get("/words/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/def-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    */
  }
}
