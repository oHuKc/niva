<%@ page import="javax.swing.plaf.basic.BasicHTML" %>
<%@ page import="internetshop.niva.il.database.jdbc.TVDAOImpl" %>
<%@ page import="internetshop.niva.il.domain.TV" %>
<%@ page import="java.util.List" %>
<%@ page import="internetshop.niva.il.database.TVDAO" %>
<%@ page import="internetshop.niva.il.database.jdbc.CartDAOImpl" %>
<%@ page import="internetshop.niva.il.domain.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp"></jsp:include>
<!-- Latest compiled and minified CSS-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
      integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
      crossorigin="anonymous">
<!-- Optional theme-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
      integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
        integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
        crossorigin="anonymous"></script>

<link rel="stylesheet" href="styles/bootstrap.min.css" >
<link rel="stylesheet" href="styles/styles.css" type="text/css"/>


<jsp:useBean id="tv_hometheater" class="internetshop.niva.il.database.jdbc.TVDAOImpl" scope="request"/>


<%--
  Created by IntelliJ IDEA.
  User: voyager
  Date: 2015.11.03.
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<br>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Menu</title>
</head>


<%
  TVDAOImpl tvdaoimpl = new TVDAOImpl();

  String sessionid = session.getId();
  String sid = request.getParameter("menusessionid");
  if (sid == null){
    sid=sessionid;
    session.setAttribute("menusessionid", sid);
  }
  String parameter = request.getParameter("parameter");
  if(parameter == null ) {
    parameter="TV & Home Theater : ";
    session.setAttribute("parameter", parameter);
  }

%>
<body>
<!--
  <div class="search-bar" role="search">
    <form action="#" name="frmSearch" method="GET">
      <label for="gh-search-input"></label>
      <input autocomplete="off" class="autocomplete-enabled" value="" name="st" maxlength="90" placeholder="" id="gh-search-input" type="text">
      <div id="autocompleteContainer"></div>

      <button type="submit" class="search-button" title="Search" value="Search">
        <span class="header-icon-search" aria-hidden="true">
        </span>
      </button>
      <input value="" name="sp" type="hidden">
-->

      </form>
    </div>
  </div>
</div>
<div class="separotor">
  <ul>

  </ul>
</div>
<div id="main-menu">
  <ul id="navmenu-v">
  <li><a href="#">TV & Home Theater</a>
     <ul>
        <li><a href="#">4K Ultra HD TVs</a>
          <ul id="4K-Ultra-HD">

            <form  method="post"  action="TV.jsp" id="4kuhd1">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd1').submit();">
              <%=tvdaoimpl.getByScreenSize("1").getTvscreensize()%>
              <input type="hidden" name="4kid1" value="1" />
              </a></li>
            </form>

            <form  method="post" action="TV.jsp" id="4kuhd2">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd2').submit();">
              <%=tvdaoimpl.getByScreenSize("2").getTvscreensize()%>
            <input type="hidden" name="4kid2" value="2" />
            </a></li>
            </form>

            <form  method="post" action="TV.jsp" id="4kuhd3">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd3').submit();">
              <%=tvdaoimpl.getByScreenSize("3").getTvscreensize()%>
              <input type="hidden" name="4kid3" value="3" /></a></li>
            </form>

            <form  method="post" action="TV.jsp" id="4kuhd4">
              <li><a href="javascript:;" onclick="document.getElementById('4kuhd4').submit();">
                <%=tvdaoimpl.getByScreenSize("4").getTvscreensize()%>
              <input type="hidden" name="4kid4" value="4" /></a></li>
            </form>


            <form  method="post" action="TV.jsp" id="4kuhd5">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd5').submit();">
              <%=tvdaoimpl.getByScreenSize("5").getTvscreensize()%>
              <input type="hidden" name="4kid5" value="5" /></a></li>
              </form>

            <form  method="post" action="TV.jsp" id="4kuhd6">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd6').submit();">
              <%=tvdaoimpl.getByScreenSize("6").getTvscreensize()%>
              <input type="hidden" name="4kid6" value="6" /></a></li>
            </form>

            <form  method="post" action="TV.jsp" id="4kuhd7">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd7').submit();">
              <%=tvdaoimpl.getByScreenSize("7").getTvscreensize()%>
              <input type="hidden" name="4kid7" value="7" /></a></li>
            </form>

          </ul>
        </li>

       <li><a href="#">LED TVs</a>
         <ul>
           <form  method="post"  action="TV.jsp" id="4kuhd10">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
               <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
               <input type="hidden" name="4kid10" value="10" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd11">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd11').submit();">
               <%=tvdaoimpl.getByScreenSize("11").getTvscreensize()%>
               <input type="hidden" name="4kid11" value="11" /></a></li>
            </form>

           <form  method="post"  action="TV.jsp" id="4kuhd12">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd12').submit();">
               <%=tvdaoimpl.getByScreenSize("12").getTvscreensize()%>
               <input type="hidden" name="4kid12" value="12" /></a></li>
            </form>

           <form  method="post"  action="TV.jsp" id="4kuhd13">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd13').submit();">
               <%=tvdaoimpl.getByScreenSize("13").getTvscreensize()%>
               <input type="hidden" name="4kid13" value="13" /></a></li>
             </form>

           <form  method="post"  action="TV.jsp" id="4kuhd14">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd14').submit();">
               <%=tvdaoimpl.getByScreenSize("14").getTvscreensize()%>
               <input type="hidden" name="4kid14" value="14" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd15">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd15').submit();">
               <%=tvdaoimpl.getByScreenSize("15").getTvscreensize()%>
               <input type="hidden" name="4kid15" value="15" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd16">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd16').submit();">
               <%=tvdaoimpl.getByScreenSize("16").getTvscreensize()%>
               <input type="hidden" name="4kid16" value="16" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd17">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd17').submit();">
               <%=tvdaoimpl.getByScreenSize("17").getTvscreensize()%>
               <input type="hidden" name="4kid17" value="17" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd18">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd18').submit();">
               <%=tvdaoimpl.getByScreenSize("18").getTvscreensize()%>
               <input type="hidden" name="4kid18" value="18" /></a></li>
           </form>

           <form  method="post"  action="TV.jsp" id="4kuhd19">
             <li><a href="javascript:;" onclick="document.getElementById('4kuhd19').submit();">
               <%=tvdaoimpl.getByScreenSize("19").getTvscreensize()%>
               <input type="hidden" name="4kid18" value="19" /></a></li>
           </form>
         </ul>
       </li>
       <li><a href="#">Outdoor TVs</a>
        <ul>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
          <form  method="get"  action="TV.jsp" id="4kuhd10">
            <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
              <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
              <input type="hidden" name="4kid10" value="10" /></a></li>
          </form>
       </ul>
       </li>
       <li><a href="#">OLED TVs</a>
       <ul>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
       </ul>
       </li>
       <li><a href="#">Curved TVs</a>
       <ul>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
       </ul>
       </li>
       <li><a href="#">Projectors & Screens</a>
       <ul>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
         <form  method="get"  action="TV.jsp" id="4kuhd10">
           <li><a href="javascript:;" onclick="document.getElementById('4kuhd10').submit();">
             <%=tvdaoimpl.getByScreenSize("10").getTvscreensize()%>
             <input type="hidden" name="4kid10" value="10" /></a></li>
         </form>
       </ul>
       </li>
       <li>
         <form  method="get"  action="TV.jsp" id="4kuhd99">
         <a href="javascript:;" onclick="document.getElementById('4kuhd99').submit();">See All Televisions</a>
         <input type="hidden" name="4kid99" value="99" />
         </form>
       </li>
  </ul>
  <li><a href="#">Cell Phones</a>
    <ul>
      <li><a href="#">Apple</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Samsung</a></li>
      <li><a href="#">LG</a></li>
      <li><a href="#">HTC</a></li>
      <li><a href="#">Motorola</a></li>
      <li><a href="#">BlackBerry</a></li>
      <li><a href="#">Kyocera</a></li>
      <li><a href="#">Microsoft</a></li>
      <li><a href="#">Pantech</a></li>
      <li><a href="#">Sharp</a></li>
      <li><a href="#">Sony</a></li>
    </ul>
  </li>
  <li><a href="#">Computers & Tablets</a>
    <ul>
      <li><a href="#">Laptops</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Tablets</a></li>
      <li><a href="#">Desktops & All-in-One Computers</a></li>
      <li><a href="#">Monitors</a></li>
      <li><a href="#">Printers, Ink & Toner</a></li>
      <li><a href="#">Hard Drives & Storage</a></li>
      <li><a href="#">Networking & Wireless</a></li>
      <li><a href="#">Computer Cards & Components</a></li>
      <li><a href="#">iPad</a></li>
      <li><a href="#">PC Gaming</a></li>
    </ul>
  </li>
  <li><a href="#">Cameras & Camcorders</a>
    <ul>
      <li><a href="#">DSLR Cameras</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Mirrorless Cameras</a></li>
      <li><a href="#">Point & Shoot Cameras </a></li>
      <li><a href="#">Traditional Camcorders</a></li>
      <li><a href="#">Action Camcorders </a></li>
      <li><a href="#">Traditional Camcorders </a></li>
      <li><a href="#">Aerial Drones</a></li>

    </ul>
  </li>
  <li><a href="#">Audio</a>
    <ul>
      <li><a href="#">iPod/MP3</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Bluetooth & Wireless Speakers</a></li>
      <li><a href="#">Docks, Radios & Boomboxes</a></li>
      <li><a href="#">Headphones</a></li>
      <li><a href="#">Home Audio</a></li>
      <li><a href="#">Speakers</a></li>
      <li><a href="#">Satellite Radio</a></li>
      <li><a href="#">Marine Audio</a></li>
    </ul>
  </li>
  <li><a href="#">Car Electronics & GPS</a>
    <ul>
      <li><a href="#">Car Audio</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">GPS Navigation & Accessories</a></li>
      <li><a href="#">Satellite Radio</a></li>
      <li><a href="#">Car Security & Remote Start</a></li>
      <li><a href="#">Car Safety & Convenience</a></li>
      <li><a href="#">Car Video</a></li>
      <li><a href="#">Radar Detectors</a></li>
    </ul>
  </li>
  <li><a href="#">Video Games, Movies & Music</a>
    <ul>
      <li><a href="">Video Games</a>
        <ul>
          <li><a href="#">Xbox One</a></li>
          <li><a href="#">Xbox 360</a></li>
          <li><a href="#">PlayStation 4</a></li>
          <li><a href="#">PlayStation 3</a></li>
          <li><a href="#">Wii U</a></li>
          <li><a href="#">Nintendo 3DS</a></li>
          <li><a href="#">PC Gaming</a></li>
        </ul>
      </li>
      <li><a href="#">Movies & TV Shows</a></li>
      <li><a href="#">Music</a></li>
    </ul>
  </li>
  <li><a href="#">Health, Fitness & Beauty</a>
    <ul>
      <li><a href="#">Apple</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Samsung</a></li>
      <li><a href="#">LG</a></li>
      <li><a href="#">HTC</a></li>
      <li><a href="#">Motorola</a></li>
      <li><a href="#">BlackBerry</a></li>
      <li><a href="#">Kyocera</a></li>
      <li><a href="#">Microsoft</a></li>
      <li><a href="#">Pantech</a></li>
      <li><a href="#">Sharp</a></li>
      <li><a href="#">Sony</a></li>
    </ul>
  </li>
  <li><a href="#">Toys, Games & Drones</a>
    <ul>
      <li><a href="#">Action Figures</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Drones & Accessories</a></li>
      <li><a href="#">App-Enabled Toys</a></li>
      <li><a href="#">Arcade Games</a></li>
      <li><a href="#">Arts & Crafts</a></li>
      <li><a href="#">Building Sets & Blocks</a></li>
      <li><a href="#">Diecast & Toy Vehicles</a></li>
      <li><a href="#">Game Room</a></li>
      <li><a href="#">Games, Puzzles & Cards</a></li>
      <li><a href="#">Kids' Electronics</a></li>
      <li><a href="#">Learning & Education</a></li>
    </ul>
  </li>
  <li><a href="#">Wearable Technology</a>
    <ul>
      <li><a href="#">Apple Watch</a>
        <ul>
          <li><a href="">Template 1</a></li>
          <li><a href="">Template 2</a></li>
          <li><a href="">Template 3</a></li>
          <li><a href="">Template 4</a></li>
          <li><a href="">Template 5</a></li>
          <li><a href="">Template 6</a></li>
          <li><a href="">Template 7</a></li>
          <li><a href="">Template 8</a></li>
        </ul>
      </li>
      <li><a href="#">Activity Trackers & Pedometers</a></li>
      <li><a href="#">Smartwatches & Accessories</a></li>
      <li><a href="#">Fitness & GPS Watches</a></li>
      <li><a href="#">Headphones</a></li>
      <li><a href="#">Smart Sports Equipment</a></li>
    </ul>
  </li>
</ul>
</div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
