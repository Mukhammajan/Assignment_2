
// API: http://localhost:8081/api/sports
const baseURL = ""; // same origin
const api = `${baseURL}/api/sports`;

const tbody = document.getElementById("tbody");
const msg = document.getElementById("msg");

async function loadSports() {
    msg.textContent = "Loading...";
    tbody.innerHTML = "";

    try {
        const res = await fetch(api);
        if (!res.ok) throw new Error(`GET failed: ${res.status}`);
        const data = await res.json();

        if (!Array.isArray(data) || data.length === 0) {
            msg.textContent = "No sports yet.";
            return;
        }

        msg.textContent = "";
        for (const s of data) {
            const tr = document.createElement("tr");
            tr.innerHTML = `
        <td>${s.id ?? ""}</td>
        <td>${escapeHtml(s.name ?? "")}</td>
        <td>${escapeHtml(s.category ?? "")}</td>
        <td><button data-id="${s.id}">Delete</button></td>
      `;
            tbody.appendChild(tr);
        }
    } catch (e) {
        msg.textContent = "Error: " + e.message;
    }
}

document.getElementById("refreshBtn").addEventListener("click", loadSports);

document.getElementById("sportForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    msg.textContent = "Saving...";

    const name = document.getElementById("name").value.trim();
    const category = document.getElementById("category").value.trim();

    try {
        const res = await fetch(api, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, category })
        });
        if (!res.ok) throw new Error(`POST failed: ${res.status}`);

        document.getElementById("name").value = "";
        document.getElementById("category").value = "";
        msg.textContent = "Added ✅";
        await loadSports();
    } catch (e2) {
        msg.textContent = "Error: " + e2.message;
    }
});

tbody.addEventListener("click", async (e) => {
    const btn = e.target.closest("button[data-id]");
    if (!btn) return;

    const id = btn.getAttribute("data-id");
    if (!id) return;

    if (!confirm(`Delete sport id=${id}?`)) return;

    try {
        const res = await fetch(`${api}/${id}`, { method: "DELETE" });
        if (!res.ok) throw new Error(`DELETE failed: ${res.status}`);
        await loadSports();
    } catch (err) {
        msg.textContent = "Error: " + err.message;
    }
});

function escapeHtml(str) {
    return String(str)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}

loadSports();
