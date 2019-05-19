$(document).ready(function () {
    $('#search_btn').click(function () {
        var title = $('#search_title').val() === "" ? null : $('#search_title').val();
        var content = $('#search_content').val() === "" ? null : $('#search_content').val();
        var afterDate = $('#search_after').val() === "" ? null : $('#search_after').val() + "T00:00";
        var beforeDate = $('#search_before').val() === "" ? null : $('#search_before').val() + "T00:00";
        var status = $('#search_status').val() === "" ? null : $('#search_status').val();
        var query = "";
        if (title != null)
            query += "&title=" + title;
        if (content != null)
            query += "&content=" + content;
        if (afterDate != null)
            query += "&afterDate=" + afterDate;
        if (beforeDate != null)
            query += "&beforeDate=" + beforeDate;
        if (status != null)
            query += "&status=" + status;
        window.location.href = window.location.origin+"/index?" + query;
    });
});
