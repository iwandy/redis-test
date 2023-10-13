function initForm() {
    let xhr = new XMLHttpRequest();
    xhr.open("post", "../articles/incr");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("id=1");
    xhr.onreadystatechange = function () {
        // 判断服务器是否正确响应
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("sp").innerHTML = xhr.response;
        }
    }
}