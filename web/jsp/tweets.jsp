<%@page import="java.util.List"%>
<%@page import="donnes.Tweet"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"></link>
        <link type="text/css" rel="stylesheet" href="css/opinion.css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="http://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
        <script src="jquery-circle-progress-1.2.1/dist/circle-progress.js"></script>
        <link type="text/css" rel="stylesheet" href="css/save.css">
        <script>
            $(document).ready(function() {
                $('#example').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
                    },
                    "scrollY": "250px",
                    "paging": false
                });
            });
        </script>
    </head>

    <body>
        <div class="div_barre">

            <img src="images/twt.jpg" id="image" />
        </div>
        <div id="light" class="white_content">
                        <div class="big-message" id="message">
                            <!--<div id="message"></div>-->
                                    </div>
                         <div class="small-message1" id="oui" >
                    <!--<div id="message"></div>-->
                        </div>
                             <div class="big-message" hidden id="message1">
                               Sauvgarde En Cours ...
                                    </div>
                             <div class="big-message1" hidden id="message3">
                              Sauvgarde Effectué
                                    </div>
                          
                        <div class="small-message2" id="nan">
                            <!--<div id="message"></div>-->
                        </div>
                       <div class="small-message3" hidden id="fermer">
                            <!--<div id="message"></div>-->
                        </div>
                      
                        <div class="small-message" id="circle">
                            <!--<div id="message"></div>-->
                        </div>

                        
                   </div>
                    <div id="fade" class="black_overlay"></div>
        <section class="container">
            <div class="login">
                <h1><font size="5">APVT</font><br>
      <font size="2">Analyse,Perception et Visualisation du territoire dans les tweets</font>
      </h1>
                <table id="example" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Pseudo</th>
                            <th>Date De Publication</th>
                            <th>Tweet</th>
                            <th>RT</th>
                            <th>Localisation</th>
                            <th>Opinion</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
                            EntityManager em = emf.createEntityManager();
                            javax.persistence.Query querhTweet = em.createQuery("select t from Tweet t ");                        
                            List<Tweet> listTweet =querhTweet.getResultList();
                         if(listTweet.size()>=1)
                         {
                            for(Tweet t:listTweet)
                            {
                          %>

                        <tr>
                            <td> <%out.print(t.getIduser().getScreenname());%></td>
                            <td> <%out.print(t.getDatecreation());%></td>
                            <td><%out.print(t.getTweetcomplet());%></td>
                            <td><%out.print(t.getRt());%></td>
                            <td><%out.print(t.getLocation());%></td>
                            <td></td>
                        </tr>
                        <%}}%>

                    </tbody>
                </table>
                 

                <p class="submit" id="Submit">
                    <input type="submit" value="Analyser" id="bttn">
                     <input id="svd" type="submit" value="Sauvgarder">
                </p>
             
            </div>
        </section>
    <script>
                         
                    
                      $( "#bttn" ).click(function(){
                     
                        $.ajax({
                        url: "analyse", // It's  my servlet
                        type : "GET",
                        data : { },
                        success: function(response){
                            alert(response);
                        }
                    });
                        });
                   
                           function AfficherCercle() {
                            var lightBox = document.getElementById('light');
                            lightBox.style.display = 'block';

                            var fadeBox = document.getElementById('fade');
                            fadeBox.style.display = 'block';
                             $('#circle').circleProgress({
                                    value:0,
                                    size: 100,
                                    fill: {
                                      gradient: ["blue", "purple"]
                                    }
                                  });
                                }
                           function AfficherMenu(message,id) {
                            var lightBox = document.getElementById('light');
                            lightBox.style.display = 'block';

                            var fadeBox = document.getElementById('fade');
                            fadeBox.style.display = 'block';

                            var msg = document.getElementById(id);
                            msg.textContent = message;
                                }
                                 function AfficherCercle() {
                            var lightBox = document.getElementById('light');
                            lightBox.style.display = 'block';

                            var fadeBox = document.getElementById('fade');
                            fadeBox.style.display = 'block';
                             $('#circle').circleProgress({
                                    value:0,
                                    size: 100,
                                    fill: {
                                      gradient: ["blue", "purple"]
                                    }
                                  });
                                }
                            function MasquerMenu() {
                                var lightBox = document.getElementById('light');
                                lightBox.style.display = 'none';

                                var fadeBox = document.getElementById('fade');
                                fadeBox.style.display = 'none';
                            }
                $( "#svd" ).click(function(){
                     AfficherMenu("voulez vous sauvegarder les résultats obtenus ?",'message');
                     AfficherMenu("Oui",'oui');
                      AfficherMenu("Nan",'nan');
     
                 });
                  $( "#nan" ).click(function(){
                    MasquerMenu();
                  });
                  $( "#fermer" ).click(function(){
                    MasquerMenu();
                  });
                  $( "#oui" ).click(function(){
                   $("#nan").hide();
                   $("#oui").hide();
                   $("#message").hide();
                   $("#message1").show();
                    AfficherCercle();
                  });
                     $(document).ready(
                        function() {
                           var x=0;
                           var y=0.1;
                     x=setInterval(function() {        
                     if( $('#circle').circleProgress('value')<=1)
                        {
                        $('#circle').circleProgress('value',y);
                          y+=0.5;
                        }
                       else
                       {
                          
                              clearInterval(x);  
                              $('#circle').hide();
                              $("#message1").hide(); 
                              $("#message3").show(); 
                               $("#fermer").show(); 
                               AfficherMenu("Fermer",'fermer');
                      /*******************************************************/
                      //alert("lol") ;
                     $.get('save', {
                     req: "sauvgarde"
                     }, function (responseText) {
                       
                    
                     alert(responseText);
                    }, false);
                    /****************************************************/
                           
                       }                                          
                },900);          
             });
                    </script>

    </body>

    </html>