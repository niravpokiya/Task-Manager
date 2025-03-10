function DeleteTask(id) {
    fetch(`http://localhost:8080/delete/${id}`, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            alert("Task deleted successfully!");
            location.reload();
        } else {
            alert("Failed to delete task or task is already deleted.");
        }
    }).catch(error => console.error("The unexpected error occured:", error));
}

function UpdateTask(id) {
    // redirecting to update task page
}