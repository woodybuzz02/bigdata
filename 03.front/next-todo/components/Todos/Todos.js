import React from 'react'
import Todo from './Todo/Todo'

    const todos = (props) => {
        const todos = props.todos.map(todo =>(
            <Todo id={todo.id} title={todo.title} description={todo.description}/>
        ));

  return (
    <ul>
        {todos}
    </ul>
  )
}

export default todos