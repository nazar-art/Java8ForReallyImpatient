package com.demo.ch7.sec02;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test3 extends Application {
   private static ScriptEngineManager manager = new ScriptEngineManager();
   private static ScriptEngine engine = manager.getEngineByName("nashorn");

   public void start(Stage stage) {
      Bindings scope = engine.createBindings();
      scope.put("stage", stage);
      try {
         engine.eval(Files.newBufferedReader(Paths.get("src/main/java/com/demo/ch7/sec02/hellofx.js")), scope);
         // Script code can access the object as stage
      } catch (IOException | ScriptException ex) {
         ex.printStackTrace();
      }
   }
}
