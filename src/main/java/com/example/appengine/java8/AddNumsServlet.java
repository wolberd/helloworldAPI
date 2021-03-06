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
import com.google.appengine.api.utils.SystemProperty;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This servlet accepts two parameters, x and y, and returns the sum in JSON
@WebServlet(name = "AddNumsServlet", value = "/addNums")
public class AddNumsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String x="";
        String y="";

        x= request.getParameter("x");
        y= request.getParameter("y");
        int numX=Integer.parseInt(x);
        int numY=Integer.parseInt(y);
        int sum=numX+numY;


        response.setContentType("text/plain");
        String jsonString= "{\"result\": \""+sum+"\"}";
        response.getWriter().println(jsonString);
    }



}
// [END example]
