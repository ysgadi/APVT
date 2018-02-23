<%@page contentType="text/html" pageEncoding="UTF-8" %>
    
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="jquery-circle-progress-1.2.1/dist/circle-progress.js"></script>
        
        
            <link type="text/css" rel="stylesheet" href="css/collect.css" />
             <link type="text/css" rel="stylesheet" href="css/Load.css">


            <title>APVT</title>
        </head>

        <body>

            <div class="div_barre">

                <img src="images/twt.jpg" id="image" />
            </div>
            <div id="light" class="white_content">
                        <div class="big-message" id="message">
                            <!--<div id="message"></div>-->
                        </div>
                         <div class="big-message" id="message2">
                            <!--<div id="message"></div>-->
                        </div>
                         <div class="big-message" id="message3">
                            <!--<div id="message"></div>-->
                        </div>
                         <div class="big-message" id="message1" >
                            <!--<div id="message"></div>-->
                        </div>
                      
                        <div class="small-message" id="circle" >
                            <!--<div id="message"></div>-->
                        </div>
                        <div class="small-message3" id="fermer">
                            <!--<div id="message"></div>-->
                        </div>
                         <div class="small-message4" id="message4">
                            <!--<div id="message"></div>-->
                            <a href="tweets" id="urll" hidden>Affiché Les Résultats</a>
                        </div>
                        
                        
                   </div>
                    <div id="fade" class="black_overlay"></div>
            <section class="container">
                <div class="login">
                    <h1><font size="5">APVT</font><br>
      <font size="2">Analyse,Perception et Visualisation du territoire dans les tweets</font>
      </h1>

                     <form id="form2" action="collect" method="post" >
                    <p><font id="fon">Recherche :</font>
                        <input id="Recherche" name="recherche"type="text" placeholder="Recherche" </p>
                        <p>
                            <input type="radio" name="cat" value="H" checked/><font id="fon">HashTag</font>
                        </p>
                        <font id="fon">Type :</font>
                        <p>
                            <input type="radio" name="cat" value="M" /><font id="fon">Mot Clé</font>
                        </p>
                      
                        <font id="fon">Ville :</font>
                        <SELECT name="Ville" id="Ville">
                            <OPTION value="Paris">Paris
                                <OPTION value="Bordeaux">Bordeaux
                                    <OPTION value="Toulouse">Toulouse
                                        <OPTION value="Marseille">Marseille
                                            <OPTION value="Pau">Pau
                        </SELECT>
                      
                       
                        <p>
                            <input type="radio" name="cat1" value="S" checked/><font id="fon">Depuis Une Date</font>
                        </p>
                         <font id="fon">Type Date :</font>
                         <p>
                            <input type="radio" name="cat1" value="R" /><font id="fon">Temp Réel</font>
                        </p>
                        <input type="date" id="Date">
                        <p class="submit" id="Submit">
                            <input type="submit" id="clique" value="Collecter"> </p>
                        </form>
                   
                    <script>
                       
                      //  var value = $('#circle').circleProgress('value');
                     </script>
                    
                    <script>
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
                $( "#clique" ).click(function(){
                     AfficherMenu("Collection En Cours ...",'message');
                     AfficherCercle();
                     $(document).ready(
                        function() {
                           var x=0;
                           var y=0.1;
                            x=setInterval(function() {
       
                     $.get('collect', {
                     req: "CollectionEnCours"
                     }, function (responseText) {
                     
                        
                     if( $('#circle').circleProgress('value')<=1 && responseText!=="tour1")
                        {
                        $('#circle').circleProgress('value',y);
                          y+=0.1;
                        }
                       else
                       {
                           if(responseText==="tour1")
                           {
                                clearInterval(x); 
                               $('#circle').circleProgress('value',1);
                               $('#message').hide();
                               $('#urll').show();
                               AfficherMenu("Collection Terminé",'message1');
                           }
                           else
                           {
                              clearInterval(x);  
                              $('#message').hide();
                              $('#circle').hide();
                              AfficherMenu("Collection Echouée",'message2');
                              AfficherMenu("Veuillez Réessayer Ultérieurement",'message3');
                              AfficherMenu("Fermer",'fermer');   
                           }
                       }
                           
                    }, false); 
                },900);          
             });
              });
                        
               $( "#fermer" ).click(function(){
                   MasquerMenu();
                   window.location.reload();

               });
               
                var frm=$("#form2");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   { 
                    //AfficherMenu("JOUER",'jouer');
                    
                   }
               });         
               return false;       
           });  
           </script>

                <script>
                $(document).ready(function(){
                    $("input[name='cat1']").on("click", function() {
                    	 if($(this).val()==='R')
                    		 {
                    		 $("#Date").hide();
                    		 }
                    	     else
                    		 $("#Date").show();
                      });
               });
                </script>
                   
                <script>
                   /*
                     $(document).ready(
                        function() {
                           var x=0;
                            x=setInterval(function() {
      
                     $.get('collect', {
                     req: "CollectionEnCours"
                     }, function (responseText) {
                         $('#circle').circleProgress('value')+=0.2;
                      //  var a=parseInt(responseText);
                     //AfficherMenu(".",'jouer');
                   // if(responseText==="tour1")
                     //{
                       //$('#circle').circleProgress('value',1); 
                      // if($('#circle').circleProgress('value')===1)
                      // { 
                      // clearInterval(x); 
                    
                      //}  
                    // }
                   //  else
                   //  $('#circle').circleProgress('value', 0.6);  
                     
                    // else
                    // {
                    //  AfficherMenu("...",'jouer');  
                    // }
                  //  $('#circle').circleProgress('value', 0.8);
                    }, false); 
                },500);          
             });
             */
                </script>
                </div>
            </section>



        </body>

        </html>