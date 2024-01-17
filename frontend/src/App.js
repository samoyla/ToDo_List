// frontend/src/App.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTaskContent, setNewTaskContent] = useState('');

  useEffect(() => {
    // Charger les tâches depuis le backend lors du montage du composant
    axios.get('http://172.23.0.3:8080/tasks') // Utilisez le nom du service du backend ici
      .then(response => {
        setTasks(response.data);
      })
      .catch(error => {
        console.error('Erreur lors du chargement des tâches', error);
      });
  }, []);

  const addTask = () => {
    // Envoyer une requête POST pour créer une nouvelle tâche
    const newTask = { content: newTaskContent, completed: false };
    axios.post('http://backend:8080/tasks', newTask)
      .then(response => {
        setTasks([...tasks, response.data]);
        setNewTaskContent('');
      })
      .catch(error => {
        console.error('Erreur lors de la création d\'une nouvelle tâche', error);
      });
  };

  const deleteTask = (taskId) => {
    // Envoyer une requête DELETE pour supprimer une tâche
    axios.delete(`http://backend:8080/tasks/${taskId}`)
      .then(() => {
        setTasks(tasks.filter(task => task.id !== taskId));
      })
      .catch(error => {
        console.error('Erreur lors de la suppression de la tâche', error);
      });
  };

  const toggleTask = (taskId) => {
    // Envoyer une requête PATCH pour marquer une tâche comme terminée ou non terminée
    axios.patch(`http://backend:8080/tasks/${taskId}/toggle`)
      .then(response => {
        setTasks(tasks.map(task =>
          task.id === taskId ? response.data : task
        ));
      })
      .catch(error => {
        console.error('Erreur lors du basculement de l\'état de la tâche', error);
      });
  };

  return (
    <div>
      <h1>Liste des tâches</h1>
      <ul>
        {tasks.map(task => (
          <li key={task.id}>
            {task.content} - {task.completed ? 'Terminée' : 'En cours'}
            <button onClick={() => deleteTask(task.id)}>Supprimer</button>
            <button onClick={() => toggleTask(task.id)}>Toggle</button>
          </li>
        ))}
      </ul>
      <div>
        <input
          type="text"
          value={newTaskContent}
          onChange={(e) => setNewTaskContent(e.target.value)}
        />
        <button onClick={addTask}>Ajouter une tâche</button>
      </div>
    </div>
  );
}

export default App;


