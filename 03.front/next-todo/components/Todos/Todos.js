import React from 'react'
import Todo from './Todo/Todo'

    const todos = (props) => {
        const deleteTodo = (id) => {
          props.deleteTodo(id)
        }


        const todos = props.todos.map(todo =>(
            <Todo 
              key={todo.id} 
              id={todo.id} 
              title={todo.title} 
              description={todo.description}
              deleteTodo={deleteTodo}
              />
        ));

  return (
    <ul>
        {todos}
    </ul>
  )
}

export default todos