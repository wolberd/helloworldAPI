/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.java8;


// [START example]

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

// This servlet returns a list of Foo objects in json form. Foo is an inner class of this class
@WebServlet(name = "ReturnListOfObjServlet", value = "/listObj")
public class ReturnListOfObjServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Properties properties = System.getProperties();

    response.setContentType("text/plain");
    Gson gson = new Gson();
    ArrayList<Foo> list = new ArrayList<Foo>();
    Foo f1= new Foo();
    Foo f2=new Foo();
    f2.a=9;
    f2.b=11;
    list.add(f1);
    list.add(f2);
    String jsonString = gson.toJson(list);
    response.getWriter().println(jsonString);
  }

  public class Foo {
    public int a=1;
    public int b=2;
  }

  public static String getInfo() {
    return "Version: " + System.getProperty("java.version")
            + " OS: " + System.getProperty("os.name")
            + " User: " + System.getProperty("user.name");
  }



}
// [END example]
