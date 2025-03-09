function DeleteTask(id) {
    fetch(`http://localhost:8080/delete/${id}`, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            alert("Task deleted successfully!");
            location.reload();
        } else {
            alert("Failed to delete task or task already deleted.");
        }
    }).catch(error => console.error("Error:", error));
}

function UpdateTask(id) {

}