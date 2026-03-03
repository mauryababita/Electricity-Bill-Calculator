function calculateBill() {
    const name = document.getElementById("name").value.trim();
    const prev = parseInt(document.getElementById("prev").value);
    const curr = parseInt(document.getElementById("curr").value);
    const resultDiv = document.getElementById("result");

    if (!name || isNaN(prev) || isNaN(curr) || curr < prev) {
        resultDiv.innerHTML = "<p style='color:red'>Please enter valid inputs.</p>";
        return;
    }

    fetch("http://localhost:8080/api/bill/calculate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, prevReading: prev, currReading: curr })
    })
    .then(response => response.json())
    .then(data => {
        resultDiv.innerHTML = `
          <h3>Bill Details</h3>
          <p><strong>Name:</strong> ${data.name}</p>
          <p><strong>Units Consumed:</strong> ${data.currReading - data.prevReading}</p>
          <p><strong>Total Bill:</strong> ₹${data.billAmount}</p>
        `;
    })
    .catch(err => {
        resultDiv.innerHTML = "<p style='color:red'>Error connecting to backend.</p>";
        console.error(err);
    });
}
