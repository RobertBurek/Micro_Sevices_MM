var client = null;

function server() {
    client = Stomp.client('ws://localhost:8080/maestro');
    client.connect({}, function (frame) {
        client.subscribe("/topic/courses", function(message){
            console.log(message);
        });
    })
}

function start() {
    var messageToSend = "";
    if (client.connected === true) client.send("/app/maestro",{},JSON.stringify({'value': messageToSend}));
    setTimeout("start()",100);
}
