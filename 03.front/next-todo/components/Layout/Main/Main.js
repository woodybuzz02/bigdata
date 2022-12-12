import React from 'react'
import Todos from '../../Todos/Todos';
import styles from './Main.module.css'
import PlusIcon from '../../../public/static/svg/plus.svg'
import { useRouter } from 'next/router'


const Main = (props) => {
    // console.log(props.todos);
    const router = useRouter();
    

    // Add Todo
    const addTodo = () => {
      console.log('addTodo');
      router.push('/todo/add');
    }

    // Delete Todo
    const deleteTodo = (id) => {
      props.deleteTodo(id);
    }

    // Update Todo
    const putTodo = (todo) => {
      props.putTodo(todo);
    }


    return (
    <>
        <div className={styles['todo-header']}>
          <PlusIcon className={styles['new-todo']} onClick={addTodo}/>
          <input className={styles['search-todo']} type="text" placeholder="What needs to be done?" autoFocus/>
        </div>
        <Todos 
          todos={props.todos}
          deleteTodo={deleteTodo}
          putTodo={putTodo}
        />
    </>
    )
}

export default Main