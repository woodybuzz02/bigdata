import React from 'react'
import Todo from './Todo/Todo'

    const todos = (props) => {

        const deleteTodo = (id) => {
          props.deleteTodo(id)
        }

        const putTodo = (todo) => {
          props.putTodo(todo)
        }


        const todos = props.todos.map(todo =>(
            <Todo 
              key={todo.id} 
              id={todo.id} 
              title={todo.title} 
              description={todo.description}
              deleteTodo={deleteTodo}
              putTodo={putTodo}
              />
        ));

  return (
    <ul>
        {todos}
    </ul>
  )
}

export default todos