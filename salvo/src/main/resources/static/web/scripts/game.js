  //        VARIABLES FOR CREATING THE GRID FOR PLAYER
  var gamePlayerNumber;
  var gamePlayer;
  var createdURL;

  //    var for end of url
  var search = location.search;

  //execute function for making the number used to generate json url
  paramObj(search);

  //function takes location and creates a number to be added to json url
  function paramObj(search) {
      var obj = {};
      var reg = /(?:[?&]([^?&#=]+)(?:=([^&#]*))?)(?:#.*)?/g;

      search.replace(reg, function (match, param, val) {
          obj[decodeURIComponent(param)] = val === undefined ? "" : decodeURIComponent(val);
      });


      gamePlayerNumber = obj.gp;
      //      console.log(gamePlayer);


      inputFunction(gamePlayerNumber);
      return obj;
  }

  //TAKES NUMBER FROM INPUT, STORES IN VAR playerNumber



  function inputFunction(gamePlayerNumber) {

      //      console.clear();
      //      $("#demo").html("");
      //      console.log("Cleared space")
      console.log("Nice fresh url for AJAX....");
      //      var input = document.getElementById("input");
      //      gamePlayerNumber = input.value;
      console.log("creating URL for GP " + gamePlayerNumber)
      makeUrl();


  }


  function makeUrl() {
      createdURL = ('http://localhost:8080/api/game_view/' + gamePlayerNumber);
      console.log(createdURL);

      makeAJAX(createdURL);
      return 'http://localhost:8080/api/game_view/' + gamePlayerNumber;

  }



  function makeAJAX(createdURL) {
      console.log("ajax");
      $.ajax({
          dataType: "json",
          url: createdURL,
          cache: true,
          data: JSON,
          success: function (data2) {
              data = data2;
              console.log(data);

              var shipLocations = data2.ships;
              console.log(shipLocations);


              //        CREATES GRID ON AJAX SUCCESS

              createGrid(data, $("#demo"));
              createGrid2(data, $("#salvoes"));

              whosPlaying(data);



          }
      });
  }


  //CREATES GRID FOR THE PLAYER
  var letters = ["0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
  var numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];



  function createGrid(data, location) {
      //      console.log(data);

      numbers.forEach(function (number) {
          //        console.log(number);

          var rowTemplate = $("<div>");
          rowTemplate.addClass("flex-grid-thirds");
          location.append(rowTemplate);
          var rowClass = ("row" + number);
          rowTemplate.addClass("row" + number);

          letters.forEach(function (letter) {
              //            console.log(letter);
              var colTemplate = $("<div>");
              colTemplate.addClass("col");
              var classSquare = (letter + number);
              colTemplate.addClass(classSquare);
              colTemplate.addClass("empty");
              rowTemplate.append(colTemplate);

              if (number == 0) {
                  var text = letter;
                  colTemplate.append(text);
                  colTemplate.removeClass("empty");
                  colTemplate.addClass("letter");
              }
              if (letter == "0") {
                  var text = number;
                  colTemplate.append(text);
                  colTemplate.removeClass("empty");
                  colTemplate.addClass("number");
              }

              for (i = 0; i < data.ships.length; i++) {
                  //                  console.log(data.ships[i]);
                  for (j = 0; j < data.ships[i].locations.length; j++) {
                      //                      console.log(data.ships[i].locations[j])
                      if (data.ships[i].locations[j] == classSquare) {

                          console.log("SHIP ON " + classSquare);
                          colTemplate.css("cssText", "background-color: yellow");
                          colTemplate.removeClass("empty");
                          colTemplate.addClass("ship");
                          colTemplate.html("ship");


                          for (k = 0; k < data.salvoes.length; k++) {
                              for (l = 0; l < data.salvoes[k].locations.length; l++) {
                                  console.log("iterated thru salvoes for every ship field");
                                  if (data.salvoes[k].locations[l] == data.ships[i].locations[j] && !(data.salvoes[k].player == gamePlayerNumber)) {
                                      console.log("got hit" + data.salvoes[k].locations[l]);
                                      colTemplate.css("cssText", "background-color: pink");
                                      colTemplate.removeClass("ship");
                                      colTemplate.addClass("hit");
                                      colTemplate.html(("ship hit on turn " + data.salvoes[k].turn))


                                  }


                              }
                          }

                      }
                      if (!(data.ships[i].locations[j] == classSquare) && colTemplate.hasClass("empty")) {
                          //                          colTemplate.html("no ship here")
                          for (k = 0; k < data.salvoes.length; k++) {
                              for (l = 0; l < data.salvoes[k].locations.length; l++) {
                                  if (data.salvoes[k].locations[l] == classSquare && !(data.salvoes[k].player == gamePlayerNumber)) {
                                      colTemplate.html("missed ship " + data.salvoes[k].turn);
                                      colTemplate.css("cssText", "background-color: violet");
                                  }
                              }
                          }



                      }




                  }
              }

          })

      })
  }


  function createGrid2(data, location) {
      console.log("CREATING GRID2");
      numbers.forEach(function (number) {
          //        console.log(number);

          var rowTemplate = $("<div>");
          rowTemplate.addClass("flex-grid-thirds");
          location.append(rowTemplate);
          var rowClass = ("row" + number);
          rowTemplate.addClass("row" + number);

          letters.forEach(function (letter) {
              //            console.log(letter);
              var colTemplate = $("<div>");
              colTemplate.addClass("col");
              var classSquare = (letter + number);
              colTemplate.addClass(classSquare);
              colTemplate.addClass("empty");
              rowTemplate.append(colTemplate);

              if (number == 0) {
                  var text = letter;
                  colTemplate.append(text);
              }
              if (letter == "0") {
                  var text = number;
                  colTemplate.append(text);
              }
              for (i = 0; i < data.salvoes.length; i++) {
                  //                  console.log(data.ships[i]);
                  for (j = 0; j < data.salvoes[i].locations.length; j++) {
                      
//                      for(k = 0; k< data.ships.length; k++){
//                          for(l = 0; l< data.ships[i].locations.length; l++){
//                              
//                          }
//                      }
                      
                      //                      console.log(data.ships[i].locations[j])
                      if (data.salvoes[i].locations[j] == classSquare && data.salvoes[i].player == gamePlayerNumber) {


                          colTemplate.css("cssText", "background-color: green");
                          var turnText = (" Salvo TURN " + data.salvoes[i].turn);
                          colTemplate.append(turnText);
                           colTemplate.addClass("ship hit");
                          console.log("SALVO ON " + classSquare);

                      }
                  }
              }

          })

      })
  }


  function whosPlaying() {
      console.log(data);
      for (i = 0; i < data.gamePlayers.length; i++) {
          console.log(data.gamePlayers[i].player.name)
          console.log(data.gamePlayers[i + 1].player.name)
          var txt1 = data.gamePlayers[i].player.name + " VS ";
          var txt2 = data.gamePlayers[i + 1].player.name;
          var txt3 = "(YOU)"

          if (data.gamePlayers[i].id.toString() == gamePlayerNumber) {
              $("#players").append(txt3);
          }
          $("#players").append(txt1);

          $("#players").append(txt2);
          if (data.gamePlayers[i + 1].id == gamePlayerNumber) {
              $("#players").append(txt3);
          }

          {
              break;
          }
      }
  }







  //$(document).ready(function () {
  //    console.log("page fuking ready!");
  //
  //    var letters = ["0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
  //    var numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  //
  //
  //
  //    numbers.forEach(function (number) {
  //        console.log(number);
  //
  //        var rowTemplate = $("<div>");
  //        rowTemplate.addClass("flex-grid-thirds");
  //        $("#demo").append(rowTemplate);
  //        var rowClass = ("row" + number);
  //        rowTemplate.addClass("row" + number);
  //
  //        letters.forEach(function (letter) {
  //            console.log(letter);
  //            var colTemplate = $("<div>");
  //            colTemplate.addClass("col");
  //            colTemplate.addClass(letter + number);
  //            rowTemplate.append(colTemplate);
  //
  //            if (number == 0) {
  //                var text = letter;
  //                colTemplate.append(text);
  //            }
  //            if (letter == "0") {
  //                var text = number;
  //                colTemplate.append(text);
  //            }
  //        })
  //
  //
  //
  //
  //
  //
  //
  //    })
  //
  //});
