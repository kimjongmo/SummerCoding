var crud = {
    delete: function(id) {
        if (window.confirm("삭제하시겠습니까?")) {
            $.ajax({
                url: "http://localhost:8080/todo/" + id,
                method: "delete",
                async: true,
                contentType: "application/json",
                data: JSON.stringify(id),
                dataType: 'text',
                success: [function (response) {
                    window.alert("알림 :" + response);
                    document.location.href = "http://localhost:8080/index";
                }]
            })
        }
    },
    update: function() {
        var id = $('#edit_id').val();
        var title = $('#edit_title').val();
        var content = $('#edit_content').val();
        var deadline = $('#edit_deadline').val() === "" ? null : $('#edit_deadline').val();
        var priority = $('#edit_selected-rating').val()===""?0:$('#edit_selected-rating').val();
        var data = {id: id, title: title, content: content, deadline: deadline,priority:priority};
        alert(JSON.stringify(data));
        if (window.confirm("수정하시겠습니까?")) {
            $.ajax({
                url: "http://localhost:8080/todo",
                method: "put",
                async: true,
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'text',
                success: [function (response) {
                    document.location.href = "http://localhost:8080/index";
                }
                ]
            });
        }
    },
    get: function(id) {
        if (window.confirm("수정하시겠습니까?")) {
            $.ajax({
                url: "http://localhost:8080/todo/" + id,
                method: "get",
                async: true,
                contentType: "application/json",
                dataType: 'json',
                success: [function (response) {
                    if (response.message == "OK") {
                        $('#edit_title').val(response.data.title);
                        $('#edit_content').val(response.data.content);
                        $('#edit_deadline').val(response.data.deadline);
                        $('#edit_id').val(response.data.id);
                        $('#edit_selected-rating').empty();
                        $('#edit_selected-rating').html(response.data.priority);
                        edit_star_fn(response.data.priority);
                        $('#edit-layer-pop').modal();
                    } else {
                        alert(response);
                    }
                }]
            })
        }
    },
    finish: function(id) {
        if (window.confirm("완료하시겠습니까?")) {
            $.ajax({
                url: "http://localhost:8080/todo/finish",
                method: "post",
                async: true,
                contentType: "application/json",
                data: JSON.stringify(id),
                dataType: 'text',
                success: [function (response) {
                    window.alert("알림 :" + response);
                    document.location.href = "http://localhost:8080/index";
                }]
            })
        }
    },
    insert : function () {
        var title = $('#title').val();
        var content = $('#content').val();
        var deadline = $('#deadline').val() === "" ? null : $('#deadline').val();
        var priority = $('#selected-rating').val()===""?0:$('#selected-rating').val();
        var data = {title: title, content: content, deadline: deadline,priority:priority};
        alert(JSON.stringify(data));
        if (window.confirm("추가하시겠습니까?") === false)
            return;
        $.ajax({
            url: "http://localhost:8080/todo",
            method: "post",
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'text',
            success: [function (response) {
                window.alert("알림 :" + response);
                document.location.href = "http://localhost:8080/index";
            }
            ]
        });
    }
};
