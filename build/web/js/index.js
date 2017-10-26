$(document).ready(function() {
    $('a.article-preview').children().hide();
    $('a.article-preview').find("p:not(:has(>*)):first").show();
})