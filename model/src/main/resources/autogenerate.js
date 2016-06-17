var FILENAME = "map5.txt";
var QUERYFILE = "map5.sql";
var MAPID = 4;
var POSSIBLEDIR = ["UP", "DOWN", "LEFT", "RIGHT", "TOPLEFT", "TOPRIGHT", "BOTTOMLEFT", "BOTTOMRIGHT"];
var randomDir = function () {
    return "\""+POSSIBLEDIR[Math.round(Math.random()*(POSSIBLEDIR.length-1))]+"\"";
};

var fs = require("fs");

var rawMap = fs.readFileSync("./mapTxt/"+FILENAME,"utf-8");

var rawQuery = "";

var x = 0;
var y = 0;
for(var i = 0; i<rawMap.length; i++){
    var type = null;
    var direction = "NULL";
    switch(rawMap[i]){
        case 'p':
            type = "door";
            break;
        case 'v':
            type = "vertical-wall";
            break;
        case 'h':
            type = "horizontal-wall";
            break;
        case 'c':
            type = "cross-wall";
            break;
        case 'd':
            type = "monster";
            direction = randomDir();
            break;
        case 'l':
            type = "hero";
            direction = randomDir();
            break;
        case 'a':
            type = "money";
            break;
        case 'b':
            type = "life-bubble";
            break;
        case '\n':
            x = 0;
            y++;
            break;
        case '\r':
            console.log("Skipped \\r character");
            break;
        case ' ':
            x++;
            break;
        default:
            console.error("Unreconized character "+rawMap[i]);
            x++;
            break
    }
    if(type != null){
        rawQuery += "INSERT INTO element VALUES (NULL,\""+type+"\","+x+","+y+","+direction+","+MAPID+");\n";
        x++;
    }
}
fs.writeFileSync("./mapsSql/"+QUERYFILE,rawQuery);
console.log("Written in mapsSql/"+QUERYFILE);