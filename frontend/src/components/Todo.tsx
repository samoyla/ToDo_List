import React, { useState, useEffect } from "react";
import axios from "axios";
import "../App.css";

interface Task {
  id: number;
  content: string;
  completed: boolean;
  type: string;
}

const Todo: React.FC = () => {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [inputTask, setInputTask] = useState<string>("");
  const [selectedType, setSelectedType] = useState<string>("");
  const [filterType, setFilterType] = useState<string| null>(null);

  useEffect(() => {
    fetchTasks();
  }, []);

  // const fetchTasks = async (typeFilter?: string) => {
  //   try {
  //     const url = typeFilter
  //     ? `http://localhost:8080/tasks?type=${typeFilter}`
  //     : "http://localhost:8080/tasks";

  //   const response = await axios.get<Task[]>(url);
  //     // const response = await axios.get<Task[]>("http://localhost:8080/tasks");
  //     setTasks(response.data);
  //   } catch (error) {
  //     console.error("Error fetching tasks", error);
  //   }
  // };

  const fetchTasks = async (typeFilter?: string) => {
    try {
      let url = "http://localhost:8080/tasks";
  
      if (typeFilter) {
        url += `?type=${typeFilter}`;
      }
  
      const response = await axios.get<Task[]>(url);
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
          type: selectedType,
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
      <div>
        <label>Filter by Type:</label>
        <select
          value={filterType || ""}
          onChange={(e) => setFilterType(e.target.value || null)}
        >
          <option value="">All</option>
          <option value="work">Work</option>
          <option value="personal">Personal</option>
          <option value="other">Other</option>
        </select>
        <button onClick={() => filterType !== null && fetchTasks(filterType)}>Apply Filter</button>
      </div>

      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.content} - Type: {task.type} - Completed: {task.completed ? "Yes" : "No"}
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
        <select value={selectedType} onChange={(e) => setSelectedType(e.target.value)}>
          <option value="default"></option>
          <option value="work">Work</option>
          <option value="personal">Personal</option>
          <option value="other">Other</option>
        </select>
        <button onClick={addTask}>Add Task</button>
      </div>
      
    </div>
  );
};

export default Todo;
