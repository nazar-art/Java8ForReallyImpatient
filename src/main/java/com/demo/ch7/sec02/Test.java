package com.demo.ch7.sec02;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
   public static void main(String[] args) throws ScriptException, IOException {
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName("nashorn");
      Object result = engine.eval("'Hello, World!'.length");
      System.out.println(result);
      result = engine.eval(Files.newBufferedReader(Paths.get("src/main/java/com/demo/ch7/sec02/hello.js")));
      System.out.println(result);
   }
}
