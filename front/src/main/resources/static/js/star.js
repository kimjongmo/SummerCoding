function add_star_fn(num) {

    var previous_value = $("#selected-rating").val();
    previous_value *= 1;//숫자 타입
    console.log("previous=" + previous_value)
    var selected_value = num;
    selected_value *= 1;//숫자 타입
    console.log("selected_value=" + selected_value)
    $("#selected-rating").val(selected_value);

    $("#selected-rating").empty();
    $("#selected-rating").html(selected_value);

    if (previous_value < selected_value) {
        for (var i = previous_value + 1; i <= selected_value; i++) {
            $("#rating-star-" + i).toggleClass('btn-default');
            $("#rating-star-" + i).toggleClass('btn-warning');
            console.log("i=" + i);
        }
    } else {
        for (var j = selected_value + 1; j <= previous_value; j++) {
            $("#rating-star-" + j).toggleClass('btn-warning');
            $("#rating-star-" + j).toggleClass('btn-default');
            console.log("j=" + j);
        }
    }
}

function edit_star_fn(num) {

    var previous_value = $("#edit_selected-rating").val();
    previous_value *= 1;//숫자 타입
    console.log("previous=" + previous_value)
    var selected_value = num;
    selected_value *= 1;//숫자 타입
    console.log("selected_value=" + selected_value)
    $("#edit_selected-rating").val(selected_value);

    $("#edit_selected-rating").empty();
    $("#edit_selected-rating").html(selected_value);

    if (previous_value < selected_value) {
        for (var i = previous_value + 1; i <= selected_value; i++) {
            $("#edit_rating-star-" + i).toggleClass('btn-default');
            $("#edit_rating-star-" + i).toggleClass('btn-warning');
            console.log("i=" + i);
        }
    } else {
        for (var j = selected_value + 1; j <= previous_value; j++) {
            $("#edit_rating-star-" + j).toggleClass('btn-warning');
            $("#edit_rating-star-" + j).toggleClass('btn-default');
            console.log("j=" + j);
        }
    }
}

