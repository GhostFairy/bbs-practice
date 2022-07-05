eventHandler();


function eventHandler() {
    let articleId = document.querySelector("#bbs-article-id");

    document.querySelectorAll(".bbs-delete").forEach(function (deleteBtn) {
        deleteBtn.addEventListener("click", async function () {
            if (confirm("삭제하시겠습니까?")) {
                let result = await fetch("/bbs/delete", {
                    method: "POST",
                    headers: {
                        'Content-Type': "application/x-www-form-urlencoded",
                    },
                    body: new URLSearchParams({
                        articleId: articleId.textContent,
                    })
                }).then((response) => (response.text()));

                if (result == "true") {
                    location.href = "/bbs";
                } else {
                    alert("삭제에 실패했습니다.");
                }
            }
        });
    });
}