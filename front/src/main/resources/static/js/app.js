var stompClient = null;

function send(){
    stompClient.send('/app/send',{},'hi');
}
function connect() {
    var socket = new SockJS('/stomp');
    stompClient = Stomp.over(socket);
    stompClient.connect({},function (frame) {
        console.log('Connected: '+frame);
        stompClient.subscribe('/topic/message',function (message) {
            notify(JSON.parse(message.body).content);
        })
    })
}

function notify(text) {
    if (Notification.permission !== "granted") {
        alert('알림이 비활성화되었습니다.');
    } else {
        var notification = new Notification("마감이 지난 일정이 존재합니다.", {
            icon: '/img/penguin.png',
            body: text
        });

        notification.onclick = function () {
            window.location.href = 'http://naver.com';
        }
    }
}