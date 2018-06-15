$.ajax({
    dataType: "json",
    url: "http://localhost:8080/api/games",
    cache: true,
    data: JSON,
    success: function (data2) {
        data = data2;
        console.log("AJAX success! Calling createList()");
        //        console.log(data);

        createList(data);

        function createList(data) {
            console.log("JSON data passed to function createList");
            console.log(data);
            console.log(data[0].gamePlayer[0].player.name)

            Object.keys(data).forEach(function (key) {
                console.log("LOOP START");
                console.log(key, data[key]);

                var obj = (key, data[key]);
                var date = new Date(obj.created);
                console.log(date);
                var insideP = date;
                var obj2 = obj.gamePlayer
                var name2 = "| "

                var list = document.createElement("li");
                var text = document.createElement("p");
                $("#orderedList").append(list);
                list.appendChild(text);
                var concat = 0;

                //               Object.keys(obj2).forEach(function (key) {
                //               console.log(obj.gamePlayer);
                //               });
                for (i = 0; i < obj2.length; i++) {
                    console.log("SUBLOOP START")
                    console.log(obj2[i]);
                    console.log(obj2[i].player.name);
                    if (concat == 0) {
                        var name = obj2[i].player.name;
                        var name2 = name2.concat(name +" VS ");
                        concat = 1;
                    }else{
                        var name = obj2[i].player.name;
                        var name2 = name2.concat(name);
                    }

                    console.log(name2);

                }




                text.innerHTML = insideP + "" + name2;


                console.log("LOOP END");


                var gamePlayer = obj.gamePlayer;







            });

        }




    }
});
