'use strict';

var https = require('https');

function HttpQuery(name, page, callback) {
    var options = {
        protocol: 'https:',
        host: 'jsonmock.hackerrank.com',
        path: '/api/movies/search/?Title=' + name + '&page=' + page,
        method: 'GET'
    };

    var str = '';
    var counter = 0;

    var _callback = function(response) {
        response.on('data', function (chunk) {
            str += chunk;
        });
        response.on('end', function () {
            callback(str);
        });
        response.on('error', function (error) {
            console.log(error.message);
        });
    }

    https.get(options, _callback);
}

/*
 * Implement the logic from here. The code above is
 * here as reference. Feel free to implement your
 * own http request using Node.js http/https
 */

function sampleCallback(str) {
    //console.log(str);
    var jsonObj = JSON.parse(str);
    if (jsonObj.data) {
        var data = jsonObj.data;
        data.sort(function(a, b) {
            return (b.Year === a.Year) ? a.Title < b.Title : b.Year - a.Year;
        });

        for(var i=0;i < data.length;i++) {
            console.log(data[i].Title);
        }
    }
};

/* 'data' is the search keyword from the test case*/

function displayResult(data) {
    HttpQuery(data, 1, sampleCallback);
}

function start() {
    process.stdin.resume();
    process.stdin.setEncoding("ascii");
    var input = "";
    process.stdin.on("data", function (chunk) {
        input += chunk;
    });

    process.stdin.on("end", function () {
        displayResult(input);
    });
}

start();