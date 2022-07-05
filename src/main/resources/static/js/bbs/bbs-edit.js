eventHandler();


function eventHandler() {
    let articleId = document.querySelector("#article-id");

    let articleTitle = document.querySelector("#article-title");
    articleTitle.addEventListener("input", function () {
        if (this.value.length > 50) {
            alert("최대 50자까지만 입력가능합니다.");
            this.value = this.value.substring(0, 50);
        }
    });

    let articleContent = document.querySelector("#article-content");
    articleContent.addEventListener("input", function () {
        if (this.value.length > 1000) {
            alert("최대 1000자까지만 입력가능합니다.");
            this.value = this.value.substring(0, 1000);
        }
    });

    document.querySelectorAll(".bbs-confirm").forEach(function (confirmBtn) {
        confirmBtn.addEventListener("click", async function (event) {
            event.preventDefault();

            if (articleTitle.value.length <= 0) {
                alert("제목을 입력하세요.");
                articleTitle.focus();
                return;
            }

            if (articleContent.value.length <= 0) {
                alert("내용을 입력하세요.");
                articleContent.focus();
                return;
            }

            let result = await fetch("/bbs/edit", {
                method: "POST",
                headers: {
                    'Content-Type': "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    articleId: articleId.value,
                    title: articleTitle.value,
                    content: articleContent.value,
                })
            }).then((response) => (response.text()));

            if (result == "true") {
                location.href = "/bbs/read?articleId=" + articleId.value;
            } else {
                location.href = "/";
            }

        });
    });
}