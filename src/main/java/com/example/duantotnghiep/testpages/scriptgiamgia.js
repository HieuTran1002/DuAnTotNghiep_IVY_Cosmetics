document.getElementById("discountForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var sanPhamId = document.getElementById("sanPhamId").value;
    var giamGiaId = document.getElementById("giamGiaId").value;

    fetch("/api/sanpham/" + sanPhamId + "/giamgia/" + giamGiaId, {
        method: "PATCH"
    })
        .then(response => response.json())
        .then(data => {
            if (data) {
                document.getElementById("result").innerText = "Discount applied successfully.";
            } else {
                document.getElementById("result").innerText = "Failed to apply discount.";
            }
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("result").innerText = "An error occurred.";
        });
});
