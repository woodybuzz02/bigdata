import React from 'react'
import Todos from '../../Todos/Todos';
import styles from './Main.module.css'

function Main(props) {
    console.log(props.todos);
  return (
    <div>
        <input className={styles['new-todo']} placeholder="What needs to be done?" autoFocus/>
        <Todos todos={props.todos} />

    </div>
  )
}

export default Main