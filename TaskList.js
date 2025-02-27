import React, { useEffect, useState } from "react";
import axios from "axios";

const TaskList = () => {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/api/tasks")
            .then(response => setTasks(response.data))
            .catch(error => console.error("Error:", error));
    }, []);

    return (
        <div>
            <h2>Task List</h2>
            <ul>
                {tasks.map(task => (
                    <li key={task.id}>{task.title} - {task.status}</li>
                ))}
            </ul>
        </div>
    );
};

export default TaskList;
