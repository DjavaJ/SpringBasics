package com.theironyard.novauc;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static User user;
    static HashMap <String, ArrayList> ha = new HashMap<>();
    static  ArrayList obj;


    public static void main(String[] args) {


        Spark.init();

        Spark.get("/", ((request, response) ->  {
            HashMap m = new HashMap();

            if(user == null){
                return new ModelAndView(m, "index.html");
            } else {
                m.put("namehowdy", user.name);
                return new ModelAndView(m, "messages.html");
            }
        }), new MustacheTemplateEngine()

        );

        Spark.post("/create-user", ((request, response) -> {
            String name = String.format("<h1>%s</h1>",request.queryParams("LoginName"));
            user = new User(name);

            response.redirect("/");
            return "Welcome!";
        })
        );

        Spark.post("/create-message", ((request, response) -> {
            obj = new ArrayList();
            String message = request.queryParams("messageText");
            obj.add(message);
            user.setMessages(obj);




            response.redirect("/");

            return new ModelAndView(user.getMessages(), "messages.html");





        })
        );















}
}
