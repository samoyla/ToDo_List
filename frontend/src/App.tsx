// frontend/src/App.tsx

// import axios from 'axios';
// import React, { useEffect, useState } from 'react';

// interface Task {
//   id: number;
//   content: string;
//   completed: boolean;
// }

// function App() {
//   const [tasks, setTasks] = useState<Task[]>([]);
//   const [newTaskContent, setNewTaskContent] = useState<string>('');

//   useEffect(() => {
//     // Charger les tâches depuis le backend lors du montage du composant
//     axios.get<Task[]>('http://localhost:8080/tasks')
//       .then(response => {
//         //console.log(response)
//         setTasks(response.data);
//       })
//       .catch(error => {
//         console.error('Erreur lors du chargement des tâches', error);
//         console.log('Erreur détaillée:', error.message);
//       });
//   }, []);

//   const addTask = () => {
//     // Envoyer une requête POST pour créer une nouvelle tâche
//     const newTask = { content: newTaskContent, completed: false };
//     axios.post<Task>('http://localhost:8080/tasks', newTask)
//       .then(response => {
//         setTasks([...tasks, response.data]);
//         setNewTaskContent('');
//       })
//       .catch(error => {
//         console.error('Erreur lors de la création d\'une nouvelle tâche', error);
//         console.log('Erreur détaillée:', error.message);
//       });
//   };

//   const deleteTask = (taskId: number) => {
//     // Envoyer une requête DELETE pour supprimer une tâche
//     axios.delete(`http://localhost:8080/tasks/${taskId}`)
//       .then(() => {
//         setTasks(tasks.filter(task => task.id !== taskId));
//       })
//       .catch(error => {
//         console.error('Erreur lors de la suppression de la tâche', error);
//         console.log('Erreur détaillée:', error.message);
//       });
//   };

//   const toggleTask = (taskId: number) => {
//     // Envoyer une requête PATCH pour marquer une tâche comme terminée ou non terminée
//     axios.patch<Task>(`http://localhost:8080/tasks/${taskId}/toggle`)
//       .then(response => {
//         console.log('Réponse du serveur:', response);
//         setTasks(tasks.map(task =>
//           task.id === taskId ? response.data : task
//         ));
//       })
//       .catch(error => {
//         console.error('Erreur lors du basculement de l\'état de la tâche', error);
//         console.log('Erreur détaillée:', error.message);
//       });
//   };

//   return (
//     <div>
//       <h1>Tasks's List</h1>
//       <ul>
//         {tasks.map(task => (
//           <li key={task.id}>
//             {task.content} - {task.completed ? 'Done' : 'In progress'}
//             <button onClick={() => deleteTask(task.id)}>Delete</button>
//             <button onClick={() => toggleTask(task.id)}>Toggle</button>
//           </li>
//         ))}
//       </ul>
//       <div>
//         <input
//           type="text"
//           value={newTaskContent}
//           onChange={(e) => setNewTaskContent(e.target.value)}
//         />
//         <button onClick={addTask}>Add a Task</button>
//       </div>
//     </div>
//   );
// }

// export default App;

import React from 'react';
import Todo from './components/Todo';

const App: React.FC = () => {
  return (
    <div>
      <h1>Todo App</h1>
      <Todo />
    </div>
  );
};

export default App;




