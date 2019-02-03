const RESOURCE_URL = window.location.protocol + "//" + window.location.host;
const REST_API_URL = RESOURCE_URL + "/rest";
const METHOD_GET = "GET";
const METHOD_POST = "POST";
const METHOD_PUT = "PUT";
const METHOD_DELETE = "DELETE";

const static = {
    barPage: () => window.location.replace(RESOURCE_URL + '/bar.html'),
};

const endpoints = {
    AlcoholController: {
        getAllAlcohol: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/bar/list`, callback)
    },
     AccountController: {
            createNewUser: (callback, body) => restRequest(METHOD_POST, `${REST_API_URL}/user/new`, callback, body),
            loginUser: (callback, body) => restRequest(METHOD_POST, `${REST_API_URL}/user/login`, callback, body),
            logoutUser: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/logout`, callback)
        }
};

function restRequest(method, url, callback, body) {
    console.log("restRequest method: " + method + " url: " + url + (body ? " body:" : ""));
    if (body) console.log(body);
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        console.log("status: " + this.status);
        if (this.readyState == 4 && (this.status == 200 || this.status == 201)) {
            if(callback && this.responseText) {
                console.log("executed callback with data object: " + callback.name);
                callback(this.responseText);
                //callback(JSON.parse(this.responseText));
            } else if (callback) {
                console.log("executed callback: " + callback.name);
                callback();
            }
        }
    };
    httpRequest.open(method, url, true);
    httpRequest.setRequestHeader('Accept', 'application/json');
    httpRequest.setRequestHeader("Content-type", "application/json");
    switch(method) {
        case METHOD_GET: httpRequest.send(null); break;
        case METHOD_POST: httpRequest.send(JSON.stringify(body)); break;
        case METHOD_PUT: httpRequest.send(JSON.stringify(body)); break;
        case METHOD_DELETE: httpRequest.send(null); break;
    }
}

function getCookie(key) {
    var match = document.cookie.match(new RegExp(key + '=([^;]+)'));
    if (match) return match[1];
    return null;
}
function removeCookie(key) {
    document.cookie = key + "=";
}
function setCookie(key, value) {
    document.cookie = key + "=" + value;
}





function login() {
    endpoints.UserController.loginUser(refreshButtonsStatus, {
        name: document.getElementById('name').value,
        password: document.getElementById('password').value
    });
}

function createNewUser() {
    endpoints.UserController.createNewUser(refreshButtonsStatus, {
        name: document.getElementById('name').value,
        password: document.getElementById('password').value
    });
}

function logout() {
    endpoints.UserController.logoutUser(refreshButtonsStatus);
}

function refreshButtonsStatus() {
    console.log("token: " + getCookie("token"));
    if(getCookie("token")) {
        document.getElementById('logout').style.display = "inline-block";
        document.getElementById('login').style.display = "none";
        document.getElementById('new_user').style.display = "none";
        document.getElementById('lets_play').style.display = "inline-block";
        document.getElementById('name').style.display = "none";
        document.getElementById('password').style.display = "none";
    } else {
        document.getElementById('logout').style.display = "none";
        document.getElementById('login').style.display = "inline-block";
        document.getElementById('new_user').style.display = "inline-block";
        document.getElementById('lets_play').style.display = "none";
        document.getElementById('name').style.display = "inline-block";
        document.getElementById('password').style.display = "inline-block";
    }
}





var currentUser = {};

function getView(viewId) {
    return document.getElementById(viewId).innerHTML;
}

function setView(viewId, view) {
    document.getElementById(viewId).innerHTML = view;
}
