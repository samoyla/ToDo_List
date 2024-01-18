import React, { useState, useEffect } from "react";
import axios from "axios";
import "../App.css";

interface Task {
  id: number;
  content: string;
  completed: boolean;
}

const Todo: React.FC = () => {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [inputTask, setInputTask] = useState<string>("");

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await axios.get<Task[]>("http://localhost:8080/tasks");
      setTasks(response.data);
    } catch (error) {
      console.error("Error fetching tasks", error);
    }
  };

  const addTask = async () => {
    if (inputTask.trim() !== "") {
      try {
        const response = await axios.post<Task>("http://localhost:8080/tasks", {
          content: inputTask,
          completed: false,
        });
        setTasks([...tasks, response.data]);
        setInputTask("");
      } catch (error) {
        console.error("Error adding task", error);
      }
    }
  };

  const removeTask = async (taskId: number) => {
    try {
      await axios.delete(`http://localhost:8080/tasks/${taskId}`);
      const newTasks = tasks.filter((task) => task.id !== taskId);
      setTasks(newTasks);
    } catch (error) {
      console.error("Error removing task", error);
    }
  };

  const toggleTask = async (taskId: number) => {
    try {
      const response = await axios.patch<Task>(
        `http://localhost:8080/tasks/${taskId}/toggle`
      );
      setTasks((prevTasks) =>
        prevTasks.map((task) =>
          task.id === taskId ? response.data : task
        )
      );
    } catch (error) {
      console.error("Error toggling task", error);
    }
  };

  return (
    <div className="container">
      <h2>To-Do List</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.content} - Completed: {task.completed ? "Yes" : "No"}
            <button onClick={() => removeTask(task.id)}>Remove</button>
            <button onClick={() => toggleTask(task.id)}>Toggle</button>
          </li>
        ))}
      </ul>
      <div>
        <input
          type="text"
          value={inputTask}
          onChange={(e) => setInputTask(e.target.value)}
        />
        <button onClick={addTask}>Add Task</button>
      </div>
    </div>
  );
};

export default Todo;
