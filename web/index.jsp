<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>MTH243 Project</title>
      <link href="css.css" rel="stylesheet" type="text/css" media="screen">
  </head>
  <body>

  <div id="wrap">
      <div>
          <h1>encrypt</h1>
          <form id="encryptForm" class="" name="encrypt" action="Servlet">
              <fieldset id="encryptInput">

                  <textarea name="changeThis" id="encryptText" tabindex="300"></textarea>

                  <ul>
                      <li><a>Shift</a><input type="radio" name="encrypt" value="shift" checked></li>
                      <li><a>Affine</a><input type="radio" name="encrypt" value="afine"></li>
                      <li><a>RSA</a><input type="radio" name="encrypt" value="rsa"></li>

                      <li>
                          <a>A=</a>
                          <select name="mult" size="1">
                              <option>1</option>
                              <option>3</option>
                              <option>5</option>
                              <option>7</option>
                              <option>9</option>
                          </select>
                      </li>

                      <li>
                          <a>B=</a>
                          <select name="add" size="1">
                              <option>0</option>
                              <option>1</option>
                              <option>2</option>
                              <option>3</option>
                              <option>4</option>
                          </select>
                      </li>

                  </ul>

                  <a href="#" type="submit" name="encrypt" id="encryptBtn" class="myButton right" tabindex="0">Encrypt</a>

              </fieldset>

          </form>
      </div>

      <div>
          <h1>decrypt</h1>
          <form id="decryptForm" class="" name="decrypt">
              <fieldset id="decryptInput">
                  <textarea name="stuff" id="decryptText" tabindex="300"></textarea>

                  <ul>
                      <li><a>All</a><input type="radio" name="decrypt" value="all" checked></li>
                      <li><a>Shift</a><input type="radio" name="decrypt" value="shift"></li>
                      <li><a>Affine</a><input type="radio" name="decrypt" value="afine"></li>
                      <li><a>RSA</a><input type="radio" name="decrypt" value="rsa"></li>
                  </ul>

                  <a href="#" type="submit" name="decrypt" id="decryptBtn" class="myButton right" tabindex="0">Decrypt</a>

              </fieldset>
          </form>
      </div>

      <div id="result"><p></p></div>

  </div>








  <%--<form action="Servlet">--%>
      <%--<input name="searchTerm" />--%>
      <%--<input type="submit" />--%>
  <%--</form>--%>

  </body>
</html>

<script src="jquery-2.2.0.min.js"></script>
<script src="jquery.js"></script>