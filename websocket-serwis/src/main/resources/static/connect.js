var client = null;

function showMessage(value) {
    // var newResponse = document.createElement('label');
    // newResponse.appendChild(document.createTextNode(value));
    var response = document.getElementById('response');
    // response.appendChild(newResponse);
    // response.append(newResponse);
    console.log(document.createTextNode(value).data);
    console.log(response);
    response.innerHTML=document.createTextNode(value).data;
}

function connect() {
    client = Stomp.client('ws://localhost:2222/maestro');
    client.connect({}, function (frame) {
        client.subscribe("/topic/courses", function(message){
            console.log(message);
            showMessage(JSON.parse(message.body).value)
        });
    })
}

function sendMessage() {
    var messageToSend = document.getElementById("messageToSend").value;
    client.send("/app/maestro",{},JSON.stringify({'value': messageToSend}));
}