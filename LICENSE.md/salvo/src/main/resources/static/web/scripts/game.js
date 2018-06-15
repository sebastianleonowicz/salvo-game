  //        VARIABLES FOR CREATING THE GRID FOR PLAYER
  var gamePlayerNumber;
  var gamePlayer;
  var createdURL;


 

  //TAKES NUMBER FROM INPUT, STORES IN VAR playerNumber



  function inputFunction() {

//      console.clear();
//      $("#demo").html("");
//      console.log("Cleared space")
      console.log("Nice fresh url for AJAX....");
      var input = document.getElementById("input");
      gamePlayerNumber = input.value;
      console.log("creating URL for GP " + gamePlayerNumber)
      makeUrl();


  }


  function makeUrl() {
      createdURL = ('http://localhost:8080/api/game_view/' + gamePlayerNumber);
      console.log(createdURL);

      makeAJAX(createdURL);
      return 'http://localhost:8080/api/game_view/' + gamePlayerNumber;

  }
  //"http://localhost:8080/api/game_view/1"


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
              var search = location.search;
              var shipLocations = data2.ships;
              console.log(shipLocations);


              //        CREATES GRID ON AJAX SUCCESS
              paramObj(search);
              createGrid(data);
              //              whosPlaying(data);



          }
      });
  }

  function paramObj(search) {
      var obj = {};
      var reg = /(?:[?&]([^?&#=]+)(?:=([^&#]*))?)(?:#.*)?/g;

      search.replace(reg, function (match, param, val) {
          obj[decodeURIComponent(param)] = val === undefined ? "" : decodeURIComponent(val);
      });


      gamePlayer = obj.gp;
      console.log(gamePlayer);
      return obj;
  }


  //CREATES GRID FOR THE PLAYER
  var letters = ["0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
  var numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];



  function createGrid() {
      //      console.log(data);
      numbers.forEach(function (number) {
          //        console.log(number);

          var rowTemplate = $("<div>");
          rowTemplate.addClass("flex-grid-thirds");
          $("#demo").append(rowTemplate);
          var rowClass = ("row" + number);
          rowTemplate.addClass("row" + number);

          letters.forEach(function (letter) {
              //            console.log(letter);
              var colTemplate = $("<div>");
              colTemplate.addClass("col");
              var classSquare = (letter + number);
              colTemplate.addClass(classSquare);
              rowTemplate.append(colTemplate);

              if (number == 0) {
                  var text = letter;
                  colTemplate.append(text);
              }
              if (letter == "0") {
                  var text = number;
                  colTemplate.append(text);
              }

              for (i = 0; i < data.ships.length; i++) {
                  //                  console.log(data.ships[i]);
                  for (j = 0; j < data.ships[i].locations.length; j++) {
                      //                      console.log(data.ships[i].locations[j])
                      if (data.ships[i].locations[j] == classSquare) {

                          console.log("SHIP ON " + classSquare);
                          colTemplate.css("cssText", "background-color: yellow");

                      }
                  }
              }




          })

      })
  }


  //  function whosPlaying() {
  //      console.log(data);
  //      for (i = 0; i < data.gamePlayers.length; i++) {
  //          console.log(data.gamePlayers[i].player.name)
  //          console.log(data.gamePlayers[i + 1].player.name)
  //          var txt1 = data.gamePlayers[i].player.name + " VS ";
  //          var txt2 = data.gamePlayers[i + 1].player.name;
  //          var txt3 = "(YOU)"
  //
  //          if (data.gamePlayers[i].id.toString() == gamePlayer) {
  //              $("#demo").append(txt3);
  //          }
  //          $("#demo").append(txt1);
  //
  //          $("#demo").append(txt2);
  //            if (data.gamePlayers[i+1].id == gamePlayer) {
  //              $("#demo").append(txt3);
  //          }
  //          
  //          {
  //              break;
  //          }
  //      }
  //  }







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
