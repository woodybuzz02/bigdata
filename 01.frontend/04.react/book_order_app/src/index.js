import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';

// React 17 -> 18버전으로 바뀌면서 
// 17버전에서는 ReactDOM.render()
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// 18버전에서는 ReactDOM>createRoot()
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );