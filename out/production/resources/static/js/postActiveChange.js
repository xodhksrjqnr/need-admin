function postActiveChange(id) {
    $.post("/posts/activeChange", {postId: id})
        .done(function () {
            var target = $('#button' + id);
            target.text() === '비공개' ? target.text('공개') : target.text('비공개');
        })
        .fail(function () {
            alert("error");
        });
}