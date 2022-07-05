eventHandler();


function eventHandler() {
    let cancelBtn = document.querySelector("#login-cancelbtn");
    cancelBtn.addEventListener("click", function(){
        history.back();
    });

    let loginBtn = document.querySelector("#login-loginbtn");
    loginBtn.addEventListener("click", async function (event) {
        event.preventDefault();

        let loginId = document.querySelector("#login-id");
        if(loginId.value.length <= 0) {
            alert("아이디를 입력하세요.");
            loginId.focus();
            return;
        }

        let loginPw = document.querySelector("#login-pw");
        if(loginPw.value.length <= 0) {
            alert("비밀번호를 입력하세요.");
            loginPw.focus();
            return;
        }

        let result = await fetch("/login", {
            method: "POST",
            headers: {
                'Content-Type': "application/x-www-form-urlencoded",
            },
            body: new URLSearchParams({
                id: loginId.value,
                pw: loginPw.value,
            })
        }).then((response) => (response.text()));

        if (result == "success") {
            let returnURL = new URLSearchParams(location.search).get("returnURL");
            if (returnURL != null) {
                location.href = returnURL;
            }
            else {
                location.href = "/";
            }
        } else {
            alert("로그인 실패");
        }
    });
}