eventHandler();


function eventHandler() {
    let loginBtn = document.querySelector("#login-loginbtn");
    loginBtn.addEventListener("click", async function (event) {
        event.preventDefault();

        let loginId = document.querySelector("#login-id").value;
        let loginPw = document.querySelector("#login-pw").value;

        let result = await fetch("/login", {
            method: "POST",
            headers: {
                'Content-Type': "application/x-www-form-urlencoded",
            },
            body: new URLSearchParams({
                id: loginId,
                pw: loginPw,
            })
        }).then((response) => (response.json()));

        if (result) {
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