function showAllNews(){
    document.getElementById("newsList").style = "display : block;";
}

function uploadNewImage(){
    document.getElementById("uploadImg").style = "display : block; margin: 0 auto 0; position:relative; left:36px;";
    document.getElementById("button").style = "display : none;";
}

function loadViewedNews(Field){

    var element = document.getElementById(Field);
    var count = element.innerHTML;
    if (count == '')
        count = 0;
    var ajax = new XMLHttpRequest();
    var url = "/load-visited-news-count.do"
    ajax.open("post",url+"?id="+ element.id + "&" + "count=" + count);
    ajax.send();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4){
            document.getElementById(Field).innerText = ajax.response;
        }
    }
}
