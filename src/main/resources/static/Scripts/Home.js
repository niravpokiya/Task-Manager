function DeleteTask(id) {
    fetch(`http://localhost:8080/delete/${id}`, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            alert("Task deleted successfully!");
            location.reload();
        } else {
            alert("Failed to delete task.");
        }
    }).catch(error => console.error("The unexpected error occured:", error));
}

function TaskCompleted(id) {
    fetch(`http://localhost:8080/task-completed/${id}`,
        {
            method : "POST"
        }).then(response => {
            if(response.ok) {
                console.log("Task is successfully completed.")
                // location.reload()
            }
            else {
                console.log("Some error might occured.")
            }
    }).catch(Error => console.log("Error occured : " + Error));

}

function UpdateTask(id) {
    window.location.href = `http://localhost:8080/update-task/${id}`;
}

function AddTask() {
    fetch("http://localhost:8080/add-task", {
        method:"POST"
    }).then(response => {
        if(response.ok)  {
            console.log("Success");
            location.href="http://localhost:8080/add-task"
        }
        else {
            console.log("Failure") ;
        }
    }).catch(error => console.log("The unexpected error occured." + error) )
}