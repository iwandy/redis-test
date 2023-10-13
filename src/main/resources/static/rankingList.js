let xhr;

function rank(id) {
    xhr = new XMLHttpRequest();
    xhr.open("post", "../rankingList/increment");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("id=" + id);
    xhr.onreadystatechange = function () {
        // 判断服务器是否正确响应
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("ranking").innerHTML = xhr.response;
        }
    }
}


