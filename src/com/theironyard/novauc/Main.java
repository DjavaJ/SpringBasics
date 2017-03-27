package com.theironyard.novauc;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {

    static User user;


    public static void main(String[] args) {


        Spark.init();

        Spark.get("/", ((request, response) ->  {
            HashMap m = new HashMap();

            if(user == null){
                return new ModelAndView(m, "index.html");
            } else {
                m.put("user", user);
                return new ModelAndView(m, "messages.html");
            }
        }), new MustacheTemplateEngine()

        );

        Spark.post("/create-user", ((request, response) -> {
            String name = request.queryParams("LoginName");
            user = new User(name);

            response.redirect("/");
            return "Welcome!";
        })
        );

        Spark.post("/create-message", ((request, response) -> {
            String message = request.queryParams("messageText");
            user.getMessages().add(message);

            response.redirect("/");
            return "";

        })
        );















}
}
